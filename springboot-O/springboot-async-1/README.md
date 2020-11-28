## Overview
In this demo, we will illustrate how to process a request asynchronously with an example of process an order 

# Steps  

1. **Controller**：
```
@Controller
@RequestMapping(value="/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value="/process",method = RequestMethod.POST)
    @ResponseBody
    public DeferredResult<String> processOrder(){
        log.info("主程序开始");
        DeferredResult<String> result = orderService.processOrder();
        log.info("主程序结束");
        return result;
    }

}
```
The controller will return a DeferredResult<String>, which is a string wapper given by another thread. 
The main thread will return null if you print ```result.getResult()```, but the value will be given by another thread (The listener thread) 
2. **Service**
```
@Service(value="orderSerVice")
public class OrderServiceImpl implements OrderService {    

    @Autowired
    private OrderDao orderDao;

    @Override
    public DeferredResult<String> processOrder(){
        Order order = new Order();
        String orderNumber = RandomStringUtils.randomNumeric(8);
        order.setOrderNumber(orderNumber);
        DeferredResult<String> deferredResult = orderDao.processOrder(order);
        return deferredResult;
    }
}
```
3. **DAO**
```
@Repository(value="orderDao")
@Slf4j
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private DeferredResultHolder holder;

    @Autowired
    private MockQueue mockQueue;

    private final static String ORDER="order_";

    @Override
    public DeferredResult<String> processOrder(Order order) {
        DeferredResult<String> deferredResult = new DeferredResult<>();
        new Thread(()->{
            try {
                log.info("开始处理订单逻辑"+order.getOrderNumber());
                Thread.sleep(2000); //这里模拟处理订单的过程
//                String resultStr = RandomStringUtils.randomNumeric(8);
//                Integer rNumber = Integer.parseInt(resultStr);
//                if(rNumber%5==0){
//                    deferredResult.setResult(ORDER+" failure");
//                }else{
//                    deferredResult.setResult(ORDER+" success");
//                }
                mockQueue.push(order.getOrderNumber());
                holder.getHolder().put(order.getOrderNumber(),deferredResult);
                log.info("完成处理订单逻辑" + order.getOrderNumber());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        return deferredResult;
    }
}
```
In DAO, it push the order to a mockQueue and use a holder to the current deferredResult. 
4. **MockQueue**
```
@Component
public class MockQueue {
    private List<String> orderList = new ArrayList<>();
    private Integer pointer = -1;

    public synchronized void push(String orderNumber){
        orderList.add(orderNumber);
        pointer++;
    }

    public synchronized String pop(){
        if(pointer>-1){
            int a = pointer;
            String orderNumber = orderList.remove(a);
            pointer--;
            return orderNumber;
        }
        return null;
    }

    public Integer getPointer() {
        return pointer;
    }

    public List<String> getOrderList() {
        return orderList;
    }
}
```
In the MockQueue,because of the multi-threaded environment, we have to use 'synchronized' to the 'push' and 'pop' method
5. **QueueListener**
```
@Component
@Slf4j
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private DeferredResultHolder holder;

    @Autowired
    private MockQueue mockQueue;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        new Thread(()->{
            while(true){
                if(mockQueue.getPointer()>-1){
                    String orderNumber = mockQueue.pop();
                    if(orderNumber!=null){
                        String resultStr = RandomStringUtils.randomNumeric(8);
                        Integer rNumber = Integer.parseInt(resultStr);
                        log.info("rNumber is "+rNumber);
                        if(rNumber%5==0){
                            holder.getHolder().get(orderNumber).setResult(" fail");
                        }else{
                            holder.getHolder().get(orderNumber).setResult(" success");
                        }
                        log.info("返回订单处理结果："+orderNumber);                        
                    }
                }else{
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
```
In the listener, it implements ApplicationListener<ContextRefreshedEvent> and set the result to the DeferredResult which was stored in DeferredResultHolder by DAO, then in the controller we can see the order processing result

The running result should be 
![image](https://github.com/fengandzhy/Blog/raw/master/Images/SpringBoot/4/1.PNG) 
 


## Conclusion
The reason why the DeferredResult could handle a request asynchronously is that it can make the container(controller) release it thread and enable it to process other request.
In the meantime the relationship between client and server has been remained. It is equivalent to estabishing a long connection between the client and server. 



 




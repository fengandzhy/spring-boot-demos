package org.zhouhy.springboot.async.async;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MockQueue queue;

    @Autowired
    private DeferredResultHolder holder;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        new Thread(()->{
            while(true){
                //if(StringUtils.isNoneBlank(queue.getCompleteOrder())){
                String orderNumber = queue.getCompleteOrder();
                if(holder.getMap().get(orderNumber)!=null){
                    log.info("返回订单处理结果："+orderNumber);
                    holder.getMap().get(orderNumber).setResult("place order success");
                    queue.setCompleteOrder(null);
                }else{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

package org.zhouhy.springboot.component.listener;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.zhouhy.springboot.component.DeferredResultHolder;
import org.zhouhy.springboot.component.queue.MockQueue;

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

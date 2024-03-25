package org.frank.spring.boot.schedule.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 配置了 @EnableScheduling，spring boot 启动之后, 它会根据表达式自动执行这里@Scheduled标注的方法
 * */
@Component
public class ScheduledTasks {

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTimeWithFixedRate() {
        System.out.println("Current time: " + System.currentTimeMillis() / 1000);
    }

    @Scheduled(cron = "0 * * * * *")
    public void reportCurrentTimeWithCronExpression() {
        System.out.println("Current time with cron: " + System.currentTimeMillis() / 1000);
    }
}

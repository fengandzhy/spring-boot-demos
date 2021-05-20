package spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyListener implements ApplicationListener {
    public String getInfo(){
        return "Student";
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        
    }
}

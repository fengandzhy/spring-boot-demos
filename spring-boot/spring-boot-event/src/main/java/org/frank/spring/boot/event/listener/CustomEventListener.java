package org.frank.spring.boot.event.listener;

import org.frank.spring.boot.event.events.CustomEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener {
    
    @EventListener
    public void handlerEvent(CustomEvent event){
        System.out.println("Handling custom event with message: " + event.getMessage());
    }
}

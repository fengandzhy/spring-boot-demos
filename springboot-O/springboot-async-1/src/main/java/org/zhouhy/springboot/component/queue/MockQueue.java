package org.zhouhy.springboot.component.queue;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

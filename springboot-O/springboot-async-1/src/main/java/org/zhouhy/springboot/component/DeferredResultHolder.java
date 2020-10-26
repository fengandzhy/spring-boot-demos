package org.zhouhy.springboot.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

@Component
public class DeferredResultHolder {
    private Map<String,DeferredResult<String>> holder = new HashMap<>();

    public Map<String, DeferredResult<String>> getHolder() {
        return holder;
    }

    public void setHolder(Map<String, DeferredResult<String>> holder) {
        this.holder = holder;
    }
}

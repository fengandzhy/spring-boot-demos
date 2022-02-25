package org.example.spring.boot.configuration.services.impl;

import org.example.spring.boot.configuration.services.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageServiceImpl implements MessageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);
    
    @Override
    public void serviceList() {        
        LOGGER.info("In the Service");
    }
}

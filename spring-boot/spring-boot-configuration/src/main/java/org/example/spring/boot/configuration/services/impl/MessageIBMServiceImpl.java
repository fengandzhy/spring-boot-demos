package org.example.spring.boot.configuration.services.impl;

import org.example.spring.boot.configuration.services.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MessageIBMServiceImpl implements MessageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageIBMServiceImpl.class);
    @Override
    public void serviceList() {
        LOGGER.info("In the IBM service.");
    }
}

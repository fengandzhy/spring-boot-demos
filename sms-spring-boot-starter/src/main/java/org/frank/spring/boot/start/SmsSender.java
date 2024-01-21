package org.frank.spring.boot.start;

public interface SmsSender {
    public boolean send(String message);
}

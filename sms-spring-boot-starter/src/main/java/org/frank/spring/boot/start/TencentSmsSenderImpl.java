package org.frank.spring.boot.start;

public class TencentSmsSenderImpl implements SmsSender{

    private SmsProperties.SmsMessage smsMessage;

    public TencentSmsSenderImpl(SmsProperties.SmsMessage smsProperties) {
        this.smsMessage = smsProperties;
    }
    @Override
    public boolean send(String message) {
        return false;
    }
}

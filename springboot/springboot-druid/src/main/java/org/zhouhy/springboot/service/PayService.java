package org.zhouhy.springboot.service;


import org.springframework.stereotype.Service;
import org.zhouhy.springboot.mapper.master.CapitalAccountMapper;
import org.zhouhy.springboot.mapper.slaver.RedPacketAccountMapper;

@Service
public class PayService {
    
    private final CapitalAccountMapper capitalAccountMapper;
    private final RedPacketAccountMapper redPacketAccountMapper;
    
    public PayService(CapitalAccountMapper capitalAccountMapper,RedPacketAccountMapper redPacketAccountMapper){
        this.capitalAccountMapper = capitalAccountMapper;
        this.redPacketAccountMapper = redPacketAccountMapper;
    }
    
    
}

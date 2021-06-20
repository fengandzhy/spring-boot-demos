package org.zhouhy.springboot.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zhouhy.springboot.entity.CapitalAccount;
import org.zhouhy.springboot.entity.RedPacketAccount;
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

    @Transactional(rollbackFor = Exception.class,transactionManager="masterTransactionManager")
    public void payAccount(int userId,int account) {
        CapitalAccount ca=new CapitalAccount();
        ca.setUserId(userId);
        CapitalAccount capitalDTO=this.capitalAccountMapper.selectOne(ca);
//        System.out.println(capitalDTO);
        //从账户里面扣除钱
        capitalDTO.setBalanceAmount(capitalDTO.getBalanceAmount()-account);
        this.capitalAccountMapper.updateByPrimaryKey(capitalDTO);
    }

    @Transactional(rollbackFor = Exception.class,transactionManager="slaverTransactionManager")
    public void payRedPacket(int userId,int account) {
        RedPacketAccount red= new RedPacketAccount();
        red.setUserId(userId);
        RedPacketAccount redDTO=this.redPacketAccountMapper.selectOne(red);
//        System.out.println(redDTO);
        //红包余额 加钱
        redDTO.setBalanceAmount(redDTO.getBalanceAmount()+account);
        this.redPacketAccountMapper.updateByPrimaryKey(redDTO);

        //int i=9/0;
    }

    //@Transactional(rollbackFor = Exception.class)
    public void pay(int fromUserId,int toUserId,int account){
        //账户余额 减钱
        this.payAccount(fromUserId,account);
        //红包余额 加钱
        this.payRedPacket(toUserId,account);
    }
}

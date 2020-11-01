package org.zhouhy.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zhouhy.springboot.mybatis.account.entity.CapitalAccount;
import org.zhouhy.springboot.mybatis.account.mapper.CapitalAccountMapper;
import org.zhouhy.springboot.mybatis.redpack.entity.RedPacketAccount;
import org.zhouhy.springboot.mybatis.redpack.mapper.RedPacketAccountMapper;

@Service
public class PayService {

    @Autowired
    private CapitalAccountMapper capitalAccountMapper;
    @Autowired
    private RedPacketAccountMapper redPacketAccountMapper;

    @Transactional(rollbackFor = Exception.class)
    public void payAccount(int userId,int amount){
        CapitalAccount account = new CapitalAccount();
        account.setUserId(userId);
        CapitalAccount accountDTO = this.capitalAccountMapper.selectOne(account);
        accountDTO.setBalanceAmount(accountDTO.getBalanceAmount()-amount);
        this.capitalAccountMapper.updateByPrimaryKey(accountDTO);
    }

    @Transactional(rollbackFor = Exception.class)
    public void payRedPack(int userId,int amount){
        RedPacketAccount account = new RedPacketAccount();
        account.setUserId(userId);
        RedPacketAccount accountDTO = this.redPacketAccountMapper.selectOne(account);
        accountDTO.setBalanceAmount(accountDTO.getBalanceAmount()+amount);
        this.redPacketAccountMapper.updateByPrimaryKey(accountDTO);
    }

    @Transactional(rollbackFor = Exception.class)
    public void pay(int fromUserId,int toUserId,int amount){
        this.payAccount(fromUserId,amount);
        this.payRedPack(toUserId,amount);
    }

}

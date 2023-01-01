package com.oumuanode.bank.service.impl;

import com.oumuanode.bank.dao.AccountDao;
import com.oumuanode.bank.pojo.Account;
import com.oumuanode.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Transactional
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Transactional
    @Override
    public void transfer(String fromActno, String toActno, double money) {
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance()<money) {
            throw new RuntimeException("����");
        }
        Account toAct = accountDao.selectByActno(toActno);

        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);

        //���ݿ����
        int count = accountDao.update(fromAct);
        count += accountDao.update(toAct);

        if (count != 2){
            throw new RuntimeException("ת��ʧ�ܣ���ϵ����");
        }
    }
}

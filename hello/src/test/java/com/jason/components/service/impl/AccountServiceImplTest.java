package com.jason.components.service.impl;

import com.jason.HelloApplication;
import com.jason.components.model.AccountDO;
import com.jason.components.service.AccountService;
import com.jason.dto.MessageDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by BNC on 2019/5/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloApplication.class)
public class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void saveAccount() throws Exception {
        MessageDTO msg = accountService.saveAccount(new AccountDO("123456", "123456", System.currentTimeMillis()));
        System.out.println(msg);
    }

    @Test
    public void deleteAccount() throws Exception {
    }

    @Test
    public void findAccountInfo() throws Exception {
    }

}
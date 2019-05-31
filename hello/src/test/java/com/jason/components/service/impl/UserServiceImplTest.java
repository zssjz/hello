package com.jason.components.service.impl;

import com.jason.HelloApplication;
import com.jason.components.model.AccountDO;
import com.jason.components.model.UserDO;
import com.jason.components.model.dto.UserDTO;
import com.jason.components.service.AccountService;
import com.jason.components.service.UserService;
import com.jason.dto.MessageDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by BNC on 2019/5/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloApplication.class)
public class UserServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @Test
    public void saveUser() throws Exception {
        MessageDTO msg = userService.saveUser(new UserDTO("123456", "654321", "test"));
        System.out.println(msg);
    }

    @Test
    public void findUserInfo() throws Exception {
        MessageDTO msg = userService.findUserInfo("2c90c0646b0677f6016b0678103c0000");
        System.out.println(msg);
    }

    @Test
    public void findUserDetail() throws Exception {
        MessageDTO msg = userService.findUserDetail("2c90c0646b0677f6016b0678103c0000");
        System.out.println(msg);
    }

    @Test
    public void deleteUser() throws Exception {
        MessageDTO msg = userService.deleteUser("2c90c0646af74ab2016af74aca500000");
        System.out.println(msg);
    }


}
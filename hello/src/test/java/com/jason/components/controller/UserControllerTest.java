package com.jason.components.controller;

import com.jason.HelloApplication;
import com.jason.dto.MessageDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by BNC on 2019/5/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloApplication.class)
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    public void getUserInfo() throws Exception {
        MessageDTO msg = userController.getUserInfo("2c90c0646b0677f6016b0678103c0000");
        System.out.println(msg);
    }

    @Test
    public void getUserDetail() throws Exception {
        MessageDTO msg = userController.getUserDetail("2c90c0646b0677f6016b0678103c0000");
        System.out.println(msg);
    }

}
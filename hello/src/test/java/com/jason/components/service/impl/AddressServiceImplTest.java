package com.jason.components.service.impl;

import com.jason.HelloApplication;
import com.jason.components.model.AddressDO;
import com.jason.components.service.AddressService;
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
public class AddressServiceImplTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void saveAddress() throws Exception {
        MessageDTO msg = addressService.saveAddress(new AddressDO("北京"));
        System.out.println(msg);
    }

}
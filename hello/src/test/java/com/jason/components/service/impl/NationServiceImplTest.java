package com.jason.components.service.impl;

import com.jason.HelloApplication;
import com.jason.components.model.NationDO;
import com.jason.components.service.NationService;
import com.jason.dto.MessageDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by BNC on 2019/4/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloApplication.class)
public class NationServiceImplTest {

    @Autowired
    private NationService nationService;

    @Test
    public void saveNation() throws Exception {
        NationDO nationDO = new NationDO();
        nationDO.setNationNameCN("中国");
        nationDO.setNationNameEN("China");
        MessageDTO msg = nationService.saveNation(nationDO);
        System.out.println(msg);
    }

    @Test
    public void queryNation() throws Exception {
        MessageDTO msg = nationService.queryNation("2c90c0646a2fdfb7016a2fdfdfe60000");
        System.out.println(msg);
    }

}
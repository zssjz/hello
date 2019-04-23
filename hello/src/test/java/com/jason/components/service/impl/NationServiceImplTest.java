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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

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

    @Test
    public void write() throws Exception {
        NumberFormat f = new DecimalFormat("100000");
        File file = new File("C:/Users/BNC/Desktop/rights.txt");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        int n = 000001;
        for (int i = 0; i < 1000; i++) {

            bw.write(f.format(i)+ "," + "MJ1" +getRandom(10)+"\r\n");
            //bw.newLine();
        }
        bw.close();
    }

    public static String getRandom(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;

    }

}
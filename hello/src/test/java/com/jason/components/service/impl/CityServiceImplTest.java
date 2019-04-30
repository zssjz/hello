package com.jason.components.service.impl;

import com.jason.HelloApplication;
import com.jason.components.model.CityDO;
import com.jason.components.model.NationDO;
import com.jason.components.model.dto.CityDTO;
import com.jason.components.service.CityService;
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
public class CityServiceImplTest {

    @Autowired
    private CityService cityService;

    @Test
    public void saveCity() throws Exception {
        NationDO nationDO = new NationDO();
        nationDO.setNationId("2c90c0646a2fdfb7016a2fdfdfe60000");
        CityDO cityDO = new CityDO();
        cityDO.setCityNameCN("杭州");
        cityDO.setCityNameEN("Hangzhou");
//        cityDO.setNationDO(nationDO);
        MessageDTO msg = cityService.saveCity(cityDO);
        System.out.println(msg);
    }

    @Test
    public void deleteCity() throws Exception {
        MessageDTO msg = cityService.deleteCity("2c90c0646a2fec09016a2fec1f550000");
        System.out.println(msg);
    }

    @Test
    public void queryCityInfo() throws Exception {
        MessageDTO msg = cityService.queryCityInfo("2c90c0646a2ff5ba016a2ff5cfea0000");
        System.out.println(msg);
    }

    @Test
    public void findCitiesInfo() throws Exception {
        MessageDTO msg = cityService.findCitiesInfo(new CityDTO());
        System.out.println(msg);
    }

    @Test
    public void interfaceTest() throws Exception {
        MessageDTO msg = cityService.findCitiesInfo(new CityDO());
        System.out.println(msg);
    }


}
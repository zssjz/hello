package com.jason.components.service.impl;

import com.jason.HelloApplication;
import com.jason.components.model.AddressDO;
import com.jason.components.model.PersonDO;
import com.jason.components.service.PersonService;
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
public class PersonServiceImplTest {

    @Autowired
    private PersonService personService;

    @Test
    public void savePerson() throws Exception {
        PersonDO personDO = new PersonDO();
        personDO.setName("jason");

        AddressDO addressDO = new AddressDO();
        addressDO.setPersonDO(personDO);
        addressDO.setAddress("beijing");
        personDO.setAddressDO(addressDO);
        MessageDTO msg = personService.savePerson(personDO);
        System.out.println(msg);
    }

    @Test
    public void findPerson() throws Exception {
        MessageDTO msg = personService.queryPerson("2c90c0646b3c9534016b3c9551be0000");
        System.out.println(msg);
    }

}
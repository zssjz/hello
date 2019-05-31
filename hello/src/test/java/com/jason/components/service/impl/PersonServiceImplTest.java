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
        personDO.setAddressDO(new AddressDO("12345679", "beijing"));
        MessageDTO msg = personService.savePerson(personDO);
        System.out.println(msg);
    }

}
package com.jason.components.service.impl;

import com.jason.components.model.PersonDO;
import com.jason.components.repository.PersonRepo;
import com.jason.components.service.PersonService;
import com.jason.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by BNC on 2019/5/31.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Override
    public MessageDTO savePerson(PersonDO personDO) {
        try {
            PersonDO result = personRepo.save(personDO);
            return new MessageDTO(0, HttpStatus.OK, "OK", result);
        } catch (Exception e) {
            e.printStackTrace();
            return new MessageDTO(1, HttpStatus.INTERNAL_SERVER_ERROR, "ERROR");
        }
    }

    @Override
    public MessageDTO queryPerson(String personId) {
        try {
            Optional<PersonDO> personDO = personRepo.findById(personId);
            return new MessageDTO(1, HttpStatus.OK, "OK", personDO);
        } catch (Exception e) {
            return new MessageDTO(1, HttpStatus.INTERNAL_SERVER_ERROR, "ERROR");
        }
    }
}

package com.jason.components.service.impl;

import com.jason.components.model.AddressDO;
import com.jason.components.repository.AddressRepo;
import com.jason.components.service.AddressService;
import com.jason.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Created by BNC on 2019/5/31.
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Override
    public MessageDTO saveAddress(AddressDO addressDO) {
        try {
            AddressDO result = addressRepo.save(addressDO);
            return new MessageDTO(1, HttpStatus.OK, "OK", result);
        } catch (Exception e) {
            e.printStackTrace();
            return new MessageDTO(0, HttpStatus.INTERNAL_SERVER_ERROR, "ERROR");
        }
    }
}

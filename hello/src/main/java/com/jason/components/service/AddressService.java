package com.jason.components.service;

import com.jason.components.model.AddressDO;
import com.jason.dto.MessageDTO;

/**
 * Created by BNC on 2019/5/31.
 */
public interface AddressService {

    /**
     *
     * @param addressDO
     * @return
     */
    MessageDTO saveAddress(AddressDO addressDO);
}

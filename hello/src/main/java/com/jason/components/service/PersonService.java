package com.jason.components.service;

import com.jason.components.model.PersonDO;
import com.jason.dto.MessageDTO;

/**
 * Created by BNC on 2019/5/31.
 */
public interface PersonService {

    /**
     *
     * @param personDO
     * @return
     */
    MessageDTO savePerson(PersonDO personDO);
}

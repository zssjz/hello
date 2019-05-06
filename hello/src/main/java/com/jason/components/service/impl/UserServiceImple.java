package com.jason.components.service.impl;

import com.jason.components.model.UserDO;
import com.jason.components.service.UserService;
import com.jason.dto.MessageDTO;
import org.springframework.stereotype.Service;

/**
 * Created by BNC on 2019/5/6.
 */
@Service
public class UserServiceImple implements UserService {

    @Override
    public MessageDTO saveUser(UserDO userDO) {
        return null;
    }

    @Override
    public MessageDTO findUserInfo(String accountId) {
        return null;
    }

    @Override
    public MessageDTO findUserDetail(String accountId) {
        return null;
    }
}

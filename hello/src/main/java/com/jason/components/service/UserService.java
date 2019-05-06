package com.jason.components.service;

import com.jason.components.model.AccountDO;
import com.jason.components.model.UserDO;
import com.jason.dto.MessageDTO;

/**
 * Created by BNC on 2019/5/6.
 */
public interface UserService {

    /**
     * 补充/修改用户信息
     * @param userDO
     * @return
     */
   MessageDTO saveUser(UserDO userDO);

    /**
     * 通过id获取用户基本信息
     * @param accountId
     * @return
     */
   MessageDTO findUserInfo(String accountId);

    /**
     * 通过ID获取用户所有信息
     * @param accountId
     * @return
     */
   MessageDTO findUserDetail(String accountId);

}

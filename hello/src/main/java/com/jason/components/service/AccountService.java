package com.jason.components.service;

import com.jason.components.model.AccountDO;
import com.jason.components.model.dto.UserDTO;
import com.jason.dto.MessageDTO;
import org.springframework.data.domain.Pageable;

/**
 * Created by BNC on 2019/5/6.
 */
public interface AccountService {

    /**
     * 注册账号/设置账号
     * @param userDTO
     * @return
     */
    MessageDTO saveAccount(UserDTO userDTO);

    /**
     * 主动删除账号（实际情况为修改账号删除标识）
     * @param accountId
     * @return
     */
    MessageDTO deleteAccount(String accountId);

    /**
     * 基础信息查看
     * @param accountDO
     * @return
     */
    MessageDTO findAccountInfo(AccountDO accountDO);

}

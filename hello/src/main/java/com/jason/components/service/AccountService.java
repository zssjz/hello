package com.jason.components.service;

import com.jason.components.model.AccountDO;
import com.jason.dto.MessageDTO;

/**
 * Created by BNC on 2019/5/6.
 */
public interface AccountService {

    /**
     * 注册账号/修改账号
     * @param accountDO
     * @return
     */
    MessageDTO saveAccount(AccountDO accountDO);

    /**
     * 主动删除账号
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

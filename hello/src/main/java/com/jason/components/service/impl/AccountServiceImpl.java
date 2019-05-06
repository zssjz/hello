package com.jason.components.service.impl;

import com.fasterxml.jackson.annotation.JsonView;
import com.jason.components.model.AccountDO;
import com.jason.components.repository.AccountRepository;
import com.jason.components.service.AccountService;
import com.jason.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Created by BNC on 2019/5/6.
 */
@Service
public class AccountServiceImpl implements AccountService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public MessageDTO saveAccount(AccountDO accountDO) {
        MessageDTO msg;
        try {
            AccountDO account = accountRepository.save(accountDO);
            msg = new MessageDTO(1, HttpStatus.OK, "OK", account);
        } catch (Exception e) {
            logger.error(e.getMessage());
            msg = new MessageDTO(0, HttpStatus.INTERNAL_SERVER_ERROR, "ERROR");
        }
        return msg;
    }

    @Override
    public MessageDTO deleteAccount(String accountId) {
        MessageDTO msg;
        try {
            AccountDO accountDO = new AccountDO();
            accountDO.setIsDelete(1);
            AccountDO account = accountRepository.save(accountDO);
            msg = new MessageDTO(1, HttpStatus.OK, "OK", account);
        } catch (Exception e) {
            logger.error(e.getMessage());
            msg = new MessageDTO(0, HttpStatus.INTERNAL_SERVER_ERROR, "ERROR");
        }
        return msg;
    }

    @Override
    public MessageDTO findAccountInfo(AccountDO accountDO) {
        return null;
    }
}

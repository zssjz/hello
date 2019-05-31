package com.jason.components.service.impl;

import com.fasterxml.jackson.annotation.JsonView;
import com.jason.components.model.AccountDO;
import com.jason.components.model.UserDO;
import com.jason.components.model.dto.UserDTO;
import com.jason.components.repository.AccountRepository;
import com.jason.components.repository.UserRepository;
import com.jason.components.service.AccountService;
import com.jason.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by BNC on 2019/5/6.
 */
@Service
public class AccountServiceImpl implements AccountService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public MessageDTO saveAccount(UserDTO userDTO) {
        try {
            AccountDO accountDO = new AccountDO();
            accountDO.setUsername(userDTO.getUsername());
            accountDO.setPassword(userDTO.getPassword());
            UserDO userDO = new UserDO();
            userDO.setNickname(userDTO.getNickname());
            userDO.setAccountDO(accountDO);
//            accountDO.setUserDO(userDO);
            AccountDO account = accountRepository.save(accountDO);
            return new MessageDTO(1, HttpStatus.OK, "OK", account);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new MessageDTO(0, HttpStatus.INTERNAL_SERVER_ERROR, "ERROR");
        }
    }

    @Transactional
    @Override
    public MessageDTO deleteAccount(String accountId) {
        AccountDO queryAccount = new AccountDO();
//        queryAccount.setAccountId(accountId);
        Example<AccountDO> example = Example.of(queryAccount);
        if (accountRepository.exists(example)) {
            int result = accountRepository.deleteAccount(accountId);
            if (result == 1) {
                return new MessageDTO(1, HttpStatus.OK, "OK");
            }
            return new MessageDTO(0, HttpStatus.OK, "Failed");
        } else {
            return new MessageDTO(0, HttpStatus.OK, "Not Found");
        }
    }

    @Override
    public MessageDTO findAccountInfo(AccountDO accountDO) {
        return null;
    }
}

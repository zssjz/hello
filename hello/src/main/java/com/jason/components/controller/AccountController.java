package com.jason.components.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.jason.components.model.AccountDO;
import com.jason.components.service.AccountService;
import com.jason.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by BNC on 2019/5/6.
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountService accountService;

    @JsonView(AccountDO.AccountDetailView.class)
    @PostMapping("/register")
    private MessageDTO registerAccount(@Validated AccountDO accountDO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuffer stringBuffer = new StringBuffer();
            bindingResult.getAllErrors().forEach(error -> {
                FieldError fieldError = (FieldError) error;
                stringBuffer.append(fieldError.getDefaultMessage());
                logger.warn(fieldError.getDefaultMessage());
            });
            return new MessageDTO(0, HttpStatus.BAD_REQUEST, stringBuffer);
        }
        MessageDTO msg;
        try {
            msg = accountService.saveAccount(accountDO);
        } catch (Exception e) {
            msg = new MessageDTO(0, HttpStatus.INTERNAL_SERVER_ERROR, "ERROR");
        }
        return msg;
    }
}

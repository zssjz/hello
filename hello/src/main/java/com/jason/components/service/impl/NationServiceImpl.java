package com.jason.components.service.impl;

import com.jason.components.model.NationDO;
import com.jason.components.repository.NationRepository;
import com.jason.components.service.NationService;
import com.jason.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Created by BNC on 2019/4/18.
 */
@Service
public class NationServiceImpl implements NationService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NationRepository nationRepository;

    @Override
    public MessageDTO saveNation(NationDO nationDO) {
        MessageDTO msg = null;
        try {
            NationDO result = nationRepository.save(nationDO);
            msg = new MessageDTO(1, HttpStatus.OK.value(), "OK", result);
        } catch (Exception e) {
            msg = new MessageDTO(0, HttpStatus.INTERNAL_SERVER_ERROR.value(), "ERROR");
        }
        return msg;
    }

    @Override
    public MessageDTO queryNation(String nationId) {
        MessageDTO msg = null;
        try {
            NationDO nationDO = nationRepository.getOne(nationId);
            msg = new MessageDTO(1, HttpStatus.OK.value(), "OK", nationDO);
        } catch (Exception e) {
            logger.error(e.getMessage());
            msg = new MessageDTO(0, HttpStatus.INTERNAL_SERVER_ERROR.value(), "ERROR");
        }
        return msg;
    }
}

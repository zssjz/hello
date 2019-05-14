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

import java.util.List;
import java.util.Optional;

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
        try {
            NationDO result = nationRepository.save(nationDO);
            return new MessageDTO(1, HttpStatus.OK, "OK", result);
        } catch (Exception e) {
            return new MessageDTO(0, HttpStatus.INTERNAL_SERVER_ERROR, "ERROR");
        }
    }

    /**
     *
     * @param nationId
     * @return
     */
    @Override
    public MessageDTO queryNation(String nationId) {
        try {
            // getOne是返回一个实体的引用——代理对象，findOne是返回实体。
//            NationDO nationDO = nationRepository.getOne(nationId);
            Optional<NationDO> nationDO = nationRepository.findById(nationId);
            return new MessageDTO(1, HttpStatus.OK, "OK", nationDO);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new MessageDTO(0, HttpStatus.INTERNAL_SERVER_ERROR, "ERROR");
        }
    }
}

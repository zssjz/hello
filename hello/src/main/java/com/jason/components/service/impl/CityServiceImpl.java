package com.jason.components.service.impl;

import com.jason.components.model.CityDO;
import com.jason.components.model.dto.CityDTO;
import com.jason.components.repository.CityRepository;
import com.jason.components.service.CityService;
import com.jason.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by BNC on 2019/4/18.
 */
@Service
public class CityServiceImpl implements CityService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CityRepository cityRepository;

    @Override
    public MessageDTO saveCity(CityDO cityDO) {
        MessageDTO msg = null;
        try {
            CityDO result = cityRepository.save(cityDO);
            msg = new MessageDTO(1, HttpStatus.OK.value(), "OK", result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            msg = new MessageDTO(0, HttpStatus.INTERNAL_SERVER_ERROR.value(), "ERROR");
        }
        return msg;
    }

    @Override
    public MessageDTO batchSave(List<CityDO> cityDOList) {
        return null;
    }

    @Override
    public MessageDTO deleteCity(String cityId) {
        MessageDTO msg = null;
        try {
            cityRepository.deleteById(cityId);
            msg = new MessageDTO(1, HttpStatus.OK.value(), "OK");
        } catch (Exception e) {
            logger.error(e.getMessage());
            msg = new MessageDTO(0, HttpStatus.INTERNAL_SERVER_ERROR.value(), "ERROR");
        }
        return msg;
    }

    @Override
    public MessageDTO queryCityInfo(String cityId) {
        MessageDTO msg = null;
        try {
            CityDO cityDO = cityRepository.getOne(cityId);
            msg = new MessageDTO(1, HttpStatus.OK.value(), "OK", cityDO);
        } catch (Exception e) {
            logger.error(e.getMessage());
            msg = new MessageDTO(0, HttpStatus.INTERNAL_SERVER_ERROR.value(), "ERROR");
        }
        return msg;
    }
}
package com.jason.components.service.impl;

import com.jason.components.model.CityDO;
import com.jason.components.model.dto.CityDTO;
import com.jason.components.repository.CityRepository;
import com.jason.components.service.CityService;
import com.jason.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        try {
            CityDO result = cityRepository.save(cityDO);
            return new MessageDTO(1, HttpStatus.OK, "OK", result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new MessageDTO(0, HttpStatus.INTERNAL_SERVER_ERROR, "ERROR");
        }
    }

    @Override
    public MessageDTO batchSave(List<CityDO> cityDOList) {
        return null;
    }

    @Override
    public MessageDTO deleteCity(String cityId) {
        try {
            cityRepository.deleteById(cityId);
            return new MessageDTO(1, HttpStatus.OK, "OK");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new MessageDTO(0, HttpStatus.INTERNAL_SERVER_ERROR, "ERROR");
        }
    }

    @Override
    public MessageDTO queryCityInfo(String cityId) {
        try {
            // getOne是返回一个实体的引用——代理对象，findOne是返回实体。
//            CityDO cityDO = cityRepository.getOne(cityId);
            Optional<CityDO> cityDO = cityRepository.findById(cityId);
            return new MessageDTO(1, HttpStatus.OK, "OK", cityDO);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return new MessageDTO(0, HttpStatus.INTERNAL_SERVER_ERROR, "ERROR");
        }
    }

    @Override
    public MessageDTO findCitiesInfo(CityDTO cityDTO) {
        try {
            int page = 0;
            int size = 10;
            int pageParam = cityDTO.getPageNum();
            int paramSize = cityDTO.getPageSize();
            if (pageParam > 0) {
                page = pageParam - 1;
            }
            if (paramSize > 0) {
                size = paramSize;
            }
            Pageable pageable = PageRequest.of(page, size);
            Page<CityDO> cities = cityRepository.findAll(pageable);
            return new MessageDTO(1, HttpStatus.OK, "OK", cities);
        } catch (Exception e) {
            return new MessageDTO(0, HttpStatus.INTERNAL_SERVER_ERROR, "ERROR");
        }
    }

    @Override
    public MessageDTO findCitiesInfo(CityDO cityDO) {
        try {
            int page = 0;
            int size = 10;
//            int pageParam = cityDO.getPageNum();
//            int paramSize = cityDO.getPageSize();
//            if (pageParam > 0) {
//                page = pageParam - 1;
//            }
//            if (paramSize > 0) {
//                size = paramSize;
//            }
            Pageable pageable = PageRequest.of(page, size);
            Example<CityDO> example = Example.of(cityDO);
            Page<CityDO> cities = cityRepository.findAll(example, pageable);
            return new MessageDTO(1, HttpStatus.OK, "OK", cities);
        } catch (Exception e) {
            return new MessageDTO(0, HttpStatus.INTERNAL_SERVER_ERROR, "ERROR");
        }
    }
}

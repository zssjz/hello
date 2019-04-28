package com.jason.components.controller;

import com.jason.components.model.CityDO;
import com.jason.components.service.CityService;
import com.jason.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * 部分注解在该class中的部分作用
 * -@PathVariable 从restful风格的url中获取参数，若url中没有声明的参数，则会返回错误
 * -@PathParam 从url中获取参数，以?拼接在结尾的形式，若url中没有声明参数，则取值为null
 * -@@RequestParam 从request中获取参数
 * Created by BNC on 2019/4/26.
 */
@RestController
@RequestMapping("/city")
public class CityController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CityService cityService;

    @GetMapping("/{cityId}/simpleInfo")
    public MessageDTO findCitySimpleInfo(@PathVariable String cityId) {
        if (cityId == null || "".equals(cityId)) {
            return new MessageDTO(0, HttpStatus.BAD_REQUEST, "WARNING");
        }
        MessageDTO msg;
        try {
            msg = cityService.queryCityInfo(cityId);
        } catch (Exception e) {
            msg = new MessageDTO(0, HttpStatus.INTERNAL_SERVER_ERROR, "ERROR");
        }
        return msg;
    }

    @PostMapping("/list")
    public MessageDTO findCityList(@Validated CityDO cityDO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuffer stringBuffer = new StringBuffer();
            bindingResult.getAllErrors().forEach(error -> {
                FieldError fieldError = (FieldError) error;
                logger.warn(error.getDefaultMessage());
                stringBuffer.append(error.getDefaultMessage());
            });
            return new MessageDTO(0, HttpStatus.BAD_REQUEST, new String(stringBuffer));
        }
        MessageDTO msg;
        try {
            msg = cityService.findCitiesInfo(cityDO);
        } catch (Exception e) {
            msg = new MessageDTO(0, HttpStatus.INTERNAL_SERVER_ERROR, "ERROR");
        }
        return msg;
    }

}

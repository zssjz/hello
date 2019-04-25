package com.jason.components.service;

import com.jason.components.model.CityDO;
import com.jason.components.model.dto.CityDTO;
import com.jason.dto.MessageDTO;

import java.util.List;

/**
 * Created by BNC on 2019/4/18.
 */
public interface CityService {

    /**
     * 新增或修改
     * @param cityDO
     * @return
     */
    MessageDTO saveCity(CityDO cityDO);

    /**
     * 批量新增及修改
     * @param cityDOList
     * @return
     */
    MessageDTO batchSave(List<CityDO> cityDOList);

    /**
     * 删除
     * @param cityId
     * @return
     */
    MessageDTO deleteCity(String cityId);

    /**
     * 获取详情
     * @param cityId
     * @return
     */
    MessageDTO queryCityInfo(String cityId);

    /**
     * 条件获取多条城市信息
     * @param cityDTO
     * @return
     */
    MessageDTO findCitiesInfo(CityDTO cityDTO);

}

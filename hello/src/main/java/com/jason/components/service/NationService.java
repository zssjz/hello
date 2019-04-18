package com.jason.components.service;

import com.jason.components.model.NationDO;
import com.jason.dto.MessageDTO;

/**
 * Created by BNC on 2019/4/18.
 */
public interface NationService {

    /**
     * 新增或修改国家信息
     * @param nationDO
     * @return
     */
    MessageDTO saveNation(NationDO nationDO);

    /**
     * 查询一条数据
     * @param nationId
     * @return
     */
    MessageDTO queryNation(String nationId);
}

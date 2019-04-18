package com.jason.config;

import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.stereotype.Component;

/**
 * Created by BNC on 2019/4/18.
 */
@Component
public class MySQL5TableType extends MySQL5Dialect {

    @Override
    public String getTableTypeString() {
//        return super.getTableTypeString();
        return "ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}

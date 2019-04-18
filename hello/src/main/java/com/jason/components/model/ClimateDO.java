package com.jason.components.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by BNC on 2019/4/18.
 */
@Entity
@Table(name = "basic_climate")
@org.hibernate.annotations.Table(appliesTo = "basic_climate", comment = "气候信息")
public class ClimateDO {

    @Id
    @GenericGenerator(name = "climateId", strategy = "uuid")
    @GeneratedValue(generator = "climateId")
    @Column(name = "CLIMATE_ID")
    private String climateId;

    @Column(name = "CLIMATE_NAME_CN", columnDefinition = "VARCHAR(255) COMMENT '名称（英文）'")
    private String climateNameCN;

    @Column(name = "CLIMATE_NAME_EN", columnDefinition = "VARCHAR(255) COMMENT '名称（英文）'")
    private String climateNameEN;

    @Column(name = "DESCRIPTION", columnDefinition = "VARCHAR(500) COMMENT '说明'")
    private String description;

    public ClimateDO() {
    }

    public ClimateDO(String climateNameCN, String climateNameEN, String description) {
        this.climateNameCN = climateNameCN;
        this.climateNameEN = climateNameEN;
        this.description = description;
    }

    public String getClimateId() {
        return climateId;
    }

    public void setClimateId(String climateId) {
        this.climateId = climateId;
    }

    public String getClimateNameCN() {
        return climateNameCN;
    }

    public void setClimateNameCN(String climateNameCN) {
        this.climateNameCN = climateNameCN;
    }

    public String getClimateNameEN() {
        return climateNameEN;
    }

    public void setClimateNameEN(String climateNameEN) {
        this.climateNameEN = climateNameEN;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ClimateDO{" +
                "climateId='" + climateId + '\'' +
                ", climateNameCN='" + climateNameCN + '\'' +
                ", climateNameEN='" + climateNameEN + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

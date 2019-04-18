package com.jason.components.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by BNC on 2019/4/16.
 */
@Entity
@javax.persistence.Table(name = "basic_city")
@org.hibernate.annotations.Table(appliesTo = "basic_city", comment = "城市基本信息")
public class CityDO {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "CITY_ID", length = 32)
    private String cityId;

    @Column(name = "CITY_NAME_CN", columnDefinition = "VARCHAR(255) NOT NULL COMMENT '名称（中文）'")
    private String cityNameCN;

    @Column(name = "CITY_NAME_EN", columnDefinition = "VARCHAR(255) NOT NULL COMMENT '名称（英文）'")
    private String cityNameEN;

    @Column(name = "LONGITUDE", precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(name = "LATITUDE", precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(name = "ELEVATION", precision = 5)
    private Integer elevation;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "NATION_ID")
    private NationDO nationDO;

    @Column(name = "CITY_DESCRIPTION", length = 500)
    private String cityDescription;

    public CityDO() {
    }

    public CityDO(String cityNameCN, String cityNameEN, BigDecimal longitude, BigDecimal latitude, int elevation, NationDO nationDO, String cityDescription) {
        this.cityNameCN = cityNameCN;
        this.cityNameEN = cityNameEN;
        this.longitude = longitude;
        this.latitude = latitude;
        this.elevation = elevation;
        this.nationDO = nationDO;
        this.cityDescription = cityDescription;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityNameCN() {
        return cityNameCN;
    }

    public void setCityNameCN(String cityNameCN) {
        this.cityNameCN = cityNameCN;
    }

    public String getCityNameEN() {
        return cityNameEN;
    }

    public void setCityNameEN(String cityNameEN) {
        this.cityNameEN = cityNameEN;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Integer getElevation() {
        return elevation;
    }

    public void setElevation(Integer elevation) {
        this.elevation = elevation;
    }

    public NationDO getNationDO() {
        return nationDO;
    }

    public void setNationDO(NationDO nationDO) {
        this.nationDO = nationDO;
    }

    public String getCityDescription() {
        return cityDescription;
    }

    public void setCityDescription(String cityDescription) {
        this.cityDescription = cityDescription;
    }

    @Override
    public String toString() {
        return "CityDO{" +
                "cityId='" + cityId + '\'' +
                ", cityNameCN='" + cityNameCN + '\'' +
                ", cityNameEN='" + cityNameEN + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", elevation=" + elevation +
                ", nationDO=" + nationDO +
                ", cityDescription='" + cityDescription + '\'' +
                '}';
    }
}

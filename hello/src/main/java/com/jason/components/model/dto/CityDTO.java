package com.jason.components.model.dto;

import com.jason.components.model.NationDO;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by BNC on 2019/4/18.
 */
public class CityDTO {

    private int pageSize;

    private int pageNum;

    private String cityId;

    private String cityNameCN;

    private String cityNameEN;

    private String longitude;

    private String latitude;

    private int elevation;

    private String nationNameCN;

    private String cityDescription;

    public CityDTO() {
    }

    public CityDTO(int pageSize, int pageNum, String cityId, String cityNameCN, String cityNameEN, BigDecimal longitude, BigDecimal latitude, int elevation, String nationNameCN, String cityDescription) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.cityId = cityId;
        this.cityNameCN = cityNameCN;
        this.cityNameEN = cityNameEN;
        this.longitude = transformValue(longitude);
        this.latitude = transformValue(latitude);
        this.elevation = elevation;
        this.nationNameCN = nationNameCN;
        this.cityDescription = cityDescription;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public String getNationId() {
        return nationNameCN;
    }

    public void setNationId(String nationNameCN) {
        this.nationNameCN = nationNameCN;
    }

    public String getCityDescription() {
        return cityDescription;
    }

    public void setCityDescription(String cityDescription) {
        this.cityDescription = cityDescription;
    }

    @Override
    public String toString() {
        return "CityDTO{" +
                "pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", cityId='" + cityId + '\'' +
                ", cityNameCN='" + cityNameCN + '\'' +
                ", cityNameEN='" + cityNameEN + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", elevation=" + elevation +
                ", nationNameCN='" + nationNameCN + '\'' +
                ", cityDescription='" + cityDescription + '\'' +
                '}';
    }

    /**
     * 转换为0°0'0"
     * @param value
     * @return
     */
    private String transformValue(BigDecimal value) {
        if (value == null) {
            return "0°0'0\"";
        }
        String[] valueArray = String.valueOf(value).split(".");
        String degree = valueArray[0];
        if (valueArray.length > 1) {
            BigDecimal firstStep = new BigDecimal(Integer.valueOf(valueArray[1]));
            BigDecimal minuteValue = firstStep.multiply(new BigDecimal(60));
            String[] firstArray = String.valueOf(minuteValue).split(".");
            StringBuffer minute = new StringBuffer(firstArray[0]);
            if (firstArray.length > 1) {
                BigDecimal secondStep = new BigDecimal(Integer.valueOf(firstArray[1]));
                BigDecimal secondValue = secondStep.multiply(new BigDecimal(60));
                Long second = Math.round(Double.valueOf(String.valueOf(secondValue)));
                return degree + "°" + minute + "'" + second + "\""; 
            }
            return degree + "°" + minute + "'0\"";
        }
        return degree + "°0'0\"";
    }
}

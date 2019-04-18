package com.jason.components.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by BNC on 2019/4/16.
 */
@Entity
@Table(name = "BASIC_NATION")
@org.hibernate.annotations.Table(appliesTo = "basic_nation", comment = "国家地区基本信息")
public class NationDO {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "NATION_ID", length = 32)
    private String nationId;

    @Column(name = "NATION_NAME_CN", nullable = false)
    private String nationNameCN;

    @Column(name = "NATION_NAME_EN", nullable = false)
    private String nationNameEN;

    @Column(name = "LOCATION")
    private String location;

//    @Column(name = "planet")
//    private String planet;
//
//    @Column(name = "PLANET_TYPE_ID", length = 32)
//    private String planetTypeId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "nationDO")
    private Set<CityDO> cities;

//    @Column(name = "GALAXY")
//    private String galaxy;
//
//    @Column(name = "GALAXY_ORDER")
//    private String galaxyOrder;


    public NationDO() {
    }

    public NationDO(String nationId, String nationNameCN, String nationNameEN, String location, Set<CityDO> cities) {
        this.nationId = nationId;
        this.nationNameCN = nationNameCN;
        this.nationNameEN = nationNameEN;
        this.location = location;
        this.cities = cities;
    }

    public NationDO(String nationNameCN, String nationNameEN, String location, Set<CityDO> cities) {
        this.nationNameCN = nationNameCN;
        this.nationNameEN = nationNameEN;
        this.location = location;
        this.cities = cities;
    }

//    public NationDO(String nationId, String nationNameCN, String nationNameEN, String location, Set<CityDO> cities) {
//        this.nationId = nationId;
//        this.nationNameCN = nationNameCN;
//        this.nationNameEN = nationNameEN;
//        this.location = location;
//        this.cities = cities;
//    }



    public String getNationId() {
        return nationId;
    }

    public void setNationId(String nationId) {
        this.nationId = nationId;
    }

    public String getNationNameCN() {
        return nationNameCN;
    }

    public void setNationNameCN(String nationNameCN) {
        this.nationNameCN = nationNameCN;
    }

    public String getNationNameEN() {
        return nationNameEN;
    }

    public void setNationNameEN(String nationNameEN) {
        this.nationNameEN = nationNameEN;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<CityDO> getCities() {
        return cities;
    }

    public void setCities(Set<CityDO> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "NationDO{" +
                "nationId='" + nationId + '\'' +
                ", nationNameCN='" + nationNameCN + '\'' +
                ", nationNameEN='" + nationNameEN + '\'' +
                ", location='" + location + '\'' +
                ", cities=" + cities +
                '}';
    }
}

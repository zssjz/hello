package com.jason.components.model;

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * 注解在该Class中的部分作用
 * -@Validated 校验注解JSR303/JSR-349
 * -@Entity 该类为实体类，默认使用ORM规则
 * -@javax.persistence.Table 修改默认ORM规则，设置表名
 * -@org.hibernate.annotations.Table 建表时的描述
 * -@Id 设置表主键
 * -@GenericGenerator 自定义主键生成策略
 * -@GeneratedValue JPA策略生成器
 * -@Column 修改默认ORM规则，设置字段名称，长度，以及自定义字段注释等
 * -@NotBlank 针对String类型的校验以及String.trim()后的校验
 * -@Length 设置字段长度校验规则
 * -@JsonIgnoreProperties 映射关系中忽略的字段
 * -@ManyToOne 多对一映射关系
 * -@JoinColumn 映射关联字段
 * -@Transient 忽略表中不存在的字段
 * -@JsonView 视图中过滤属性
 * 
 * Created by BNC on 2019/4/16.
 */
@ApiModel(value = "城市信息")
@Validated
@Entity
@javax.persistence.Table(name = "basic_city")
@org.hibernate.annotations.Table(appliesTo = "basic_city", comment = "城市基本信息")
public class CityDO {

    public interface CitySimpleView {};

    public interface CityDetailView extends CitySimpleView {};

    public interface CitySimpleValidate {};

    public interface CityDetailValidate {};

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "CITY_ID", length = 32)
    private String cityId;

    @ApiModelProperty(value = "cityNameCN", name = "名称（中文）", dataType = "String")
    @NotBlank(message = "城市名称（中文）不能为空", groups = CitySimpleValidate.class)
    @Length(max = 255, message = "请限制在255个字符以内", groups = CitySimpleValidate.class)
    @Column(name = "CITY_NAME_CN", columnDefinition = "VARCHAR(255) NOT NULL COMMENT '名称（中文）'")
    private String cityNameCN;

    @ApiModelProperty(value = "cityNameEN", name = "名称（英文）", dataType = "String")
    @NotBlank(message = "城市名称（英文）不能为空", groups = CitySimpleValidate.class)
    @Length(max = 255, message = "请限制在255个字符以内", groups = CitySimpleValidate.class)
    @Column(name = "CITY_NAME_EN", columnDefinition = "VARCHAR(255) NOT NULL COMMENT '名称（英文）'")
    private String cityNameEN;

    @ApiModelProperty(value = "longitude", name = "经度")
    @Column(name = "LONGITUDE", precision = 10, scale = 7)
    private BigDecimal longitude;

    @ApiModelProperty(value = "latitude", name = "纬度")
    @Column(name = "LATITUDE", precision = 10, scale = 7)
    private BigDecimal latitude;

    @ApiModelProperty(value = "elevation", name = "海拔")
    @Column(name = "ELEVATION", precision = 5)
    private Integer elevation;

    @JsonIgnoreProperties(value = {"location"})
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "NATION_ID")
    private NationDO nationDO;

    @ApiModelProperty(value = "cityDescription", name = "城市描述")
    @Length(max = 500, message = "请限制在500个字符以内", groups = CitySimpleValidate.class)
    @Column(name = "CITY_DESCRIPTION", length = 500)
    private String cityDescription;

    @Transient
    private String nationId;

    @Transient
    private int pageSize;

    @Transient
    private int pageNum;

    /**
     * 无参数构造方法
     */
    public CityDO() {
    }

    /**
     * 简化参数构造方法
     * @param cityNameCN
     * @param cityNameEN
     * @param longitude
     * @param latitude
     * @param elevation
     * @param nationDO
     */
    public CityDO(@NotBlank(message = "城市名称（中文）不能为空") @Length(max = 255, message = "请限制在255个字符以内") String cityNameCN, @NotBlank(message = "城市名称（英文）不能为空") @Length(max = 255, message = "请限制在255个字符以内") String cityNameEN, BigDecimal longitude, BigDecimal latitude, Integer elevation, NationDO nationDO) {
        this.cityNameCN = cityNameCN;
        this.cityNameEN = cityNameEN;
        this.longitude = longitude;
        this.latitude = latitude;
        this.elevation = elevation;
        this.nationDO = nationDO;
    }

    /**
     * 标准构造方法
     * @param cityNameCN
     * @param cityNameEN
     * @param longitude
     * @param latitude
     * @param elevation
     * @param nationDO
     * @param cityDescription
     */
    public CityDO(@NotBlank(message = "城市名称（中文）不能为空") @Length(max = 255, message = "请限制在255个字符以内") String cityNameCN, @NotBlank(message = "城市名称（英文）不能为空") @Length(max = 255, message = "请限制在255个字符以内") String cityNameEN, BigDecimal longitude, BigDecimal latitude, Integer elevation, NationDO nationDO, @Length(max = 500, message = "请限制在500个字符以内") String cityDescription) {
        this.cityNameCN = cityNameCN;
        this.cityNameEN = cityNameEN;
        this.longitude = longitude;
        this.latitude = latitude;
        this.elevation = elevation;
        this.nationDO = nationDO;
        this.cityDescription = cityDescription;
    }

    /**
     * 全参数构造方法
     * @param cityNameCN
     * @param cityNameEN
     * @param longitude
     * @param latitude
     * @param elevation
     * @param nationDO
     * @param cityDescription
     * @param nationId
     * @param pageSize
     * @param pageNum
     */
    public CityDO(@NotBlank(message = "城市名称（中文）不能为空") @Length(max = 255, message = "请限制在255个字符以内") String cityNameCN, @NotBlank(message = "城市名称（英文）不能为空") @Length(max = 255, message = "请限制在255个字符以内") String cityNameEN, BigDecimal longitude, BigDecimal latitude, Integer elevation, NationDO nationDO, @Length(max = 500, message = "请限制在500个字符以内") String cityDescription, String nationId, int pageSize, int pageNum) {
        this.cityNameCN = cityNameCN;
        this.cityNameEN = cityNameEN;
        this.longitude = longitude;
        this.latitude = latitude;
        this.elevation = elevation;
        this.cityDescription = cityDescription;
        this.nationId = nationId;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.nationDO = nationDO;
    }

    /**
     * 入参构造函数，针对请求
     * @param cityNameCN
     * @param cityNameEN
     * @param longitude
     * @param latitude
     * @param elevation
     * @param cityDescription
     * @param nationId
     * @param pageSize
     * @param pageNum
     */
    public CityDO(@NotBlank(message = "城市名称（中文）不能为空", groups = CitySimpleValidate.class) @Length(max = 255, message = "请限制在255个字符以内", groups = CitySimpleValidate.class) String cityNameCN, @NotBlank(message = "城市名称（英文）不能为空", groups = CitySimpleValidate.class) @Length(max = 255, message = "请限制在255个字符以内", groups = CitySimpleValidate.class) String cityNameEN, BigDecimal longitude, BigDecimal latitude, Integer elevation, @Length(max = 500, message = "请限制在500个字符以内", groups = CitySimpleValidate.class) String cityDescription, @NotBlank(message = "请输入nationId", groups = CityDetailValidate.class) String nationId, int pageSize, int pageNum) {
        this.cityNameCN = cityNameCN;
        this.cityNameEN = cityNameEN;
        this.longitude = longitude;
        this.latitude = latitude;
        this.elevation = elevation;
        this.cityDescription = cityDescription;
        this.nationId = nationId;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        NationDO nation = new NationDO();
        nation.setNationId(nationId);
        this.nationDO = nation;
    }

    @JsonView(CitySimpleView.class)
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @JsonView(CitySimpleView.class)
    public String getCityNameCN() {
        return cityNameCN;
    }

    public void setCityNameCN(String cityNameCN) {
        this.cityNameCN = cityNameCN;
    }

    @JsonView(CitySimpleView.class)
    public String getCityNameEN() {
        return cityNameEN;
    }

    public void setCityNameEN(String cityNameEN) {
        this.cityNameEN = cityNameEN;
    }

    @JsonView(CitySimpleView.class)
    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @JsonView(CitySimpleView.class)
    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @JsonView(CitySimpleView.class)
    public Integer getElevation() {
        return elevation;
    }

    public void setElevation(Integer elevation) {
        this.elevation = elevation;
    }

    @JsonView(CitySimpleView.class)
    public NationDO getNationDO() {
        return nationDO;
    }

    public void setNationDO(NationDO nationDO) {
        this.nationDO = nationDO;
    }

    @JsonView(CitySimpleView.class)
    public String getCityDescription() {
        return cityDescription;
    }

    public void setCityDescription(String cityDescription) {
        this.cityDescription = cityDescription;
    }
    
    public String getNationId() {
        return nationId;
    }

    public void setNationId(String nationId) {
        this.nationId = nationId;
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

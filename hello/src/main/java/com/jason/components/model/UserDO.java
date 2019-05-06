package com.jason.components.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Table;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.validation.constraints.*;
import java.sql.Date;

/**
 * Created by BNC on 2019/4/30.
 */
@ApiModel(value = "用户基础信息")
@Validated
@Entity
@javax.persistence.Table(name = "basic_user")
@org.hibernate.annotations.Table(appliesTo = "basic_user", comment = "用户基础信息")
public class UserDO {

    public interface userSimpleInfoView {};

    public interface userDetailInfoView extends userSimpleInfoView {};

    public interface userModifyValidate {};

    public interface userCreateValidate {};

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "accountDO"))
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "USER_ID", length = 32)
    private String userId;

    @JsonIgnoreProperties(value = {"password"})
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    private AccountDO accountDO;

    @NotBlank(message = "昵称不能为空", groups = userModifyValidate.class)
    @Max(value = 32, message = "昵称长度不能超过32个字符")
    @ApiModelProperty(name = "nickname", value = "昵称", dataType = "String")
    @Column(name = "NICKNAME", unique = true, length = 32)
    private String nickname;

    @ApiModelProperty(name = "sex", value = "性别", dataType = "int")
    private Integer sex;

    @ApiModelProperty(name = "age", value = "年龄", dataType = "int")
    @Column(name = "AGE", precision = 3)
    private Integer age;

    @Past(message = "请填写正确的生日")
    @ApiModelProperty(name = "birthday", value = "生日", dataType = "Date")
    private Date birthday;

    @Email(message = "请填写正确的邮箱地址")
    @ApiModelProperty(name = "email", value = "邮箱", dataType = "String")
    private String email;

    @Pattern(
        regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$",
        message = "请输入正确的手机号码"
    )
    @ApiModelProperty(name = "phoneNumber", value = "手机号码", dataType = "String")
    @Column(name = "PHONE_NUMBER", length = 11)
    private String phoneNumber;

    @ApiModelProperty(name = "address", value = "显示地址", dataType = "String")
    private String address;

    @ApiModelProperty(name = "nation", value = "国家地区", dataType = "String")
    private String nation;

    @ApiModelProperty(name = "province", value = "省份/洲/自治区/直辖市", dataType = "String")
    private String province;

    @ApiModelProperty(name = "city", value = "城市", dataType = "String")
    private String city;

    @ApiModelProperty(name = "district", value = "行政区/县", dataType = "String")
    private String district;

    @ApiModelProperty(name = "description", value = "个人描述", dataType = "String")
    private String description;

    @JsonView(userDetailInfoView.class)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonView(userSimpleInfoView.class)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @JsonView(userSimpleInfoView.class)
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @JsonView(userDetailInfoView.class)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonView(userDetailInfoView.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @JsonView(userDetailInfoView.class)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonView(userDetailInfoView.class)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonView(userDetailInfoView.class)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @JsonView(userDetailInfoView.class)
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @JsonView(userDetailInfoView.class)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @JsonView(userDetailInfoView.class)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @JsonView(userDetailInfoView.class)
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @JsonView(userDetailInfoView.class)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AccountDO getAccountDO() {
        return accountDO;
    }

    public void setAccountDO(AccountDO accountDO) {
        this.accountDO = accountDO;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "userId='" + userId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", nation='" + nation + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", description='" + description + '\'' +
                ", accountDO=" + accountDO +
                '}';
    }
}

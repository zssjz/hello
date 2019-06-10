package com.jason.components.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

/**
 * Created by BNC on 2019/5/31.
 */
@Entity
@Table(name = "basic_address")
public class AddressDO {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "ADDRESS_ID")
    private String addressId;

    private String address;

    @OneToOne(mappedBy = "addressDO")
    private PersonDO personDO;

    public AddressDO() {
    }

    public AddressDO(String addressId, String address) {
        this.address = address;
        this.addressId = addressId;
    }

    public AddressDO(String address) {
        this.address = address;
    }

    public PersonDO getPersonDO() {
        return personDO;
    }

    public void setPersonDO(PersonDO personDO) {
        this.personDO = personDO;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

package com.jason.components.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by BNC on 2019/5/31.
 */
@Entity
@Table(name = "basic_person")
public class PersonDO {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String personId;

    private String name;

    @OneToOne
    @JoinColumn(name = "ADDRESS_ID")
    private AddressDO addressDO;

    public PersonDO() {
    }

    public PersonDO(String name, AddressDO addressDO) {
        this.name = name;
        this.addressDO = addressDO;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDO getAddressDO() {
        return addressDO;
    }

    public void setAddressDO(AddressDO addressDO) {
        this.addressDO = addressDO;
    }
}

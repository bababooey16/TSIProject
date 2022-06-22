package com.tsi.pedro.Project;


import javax.persistence.*;

@Entity
@Table(name ="address")

public class Address {
    //Attributes
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int address_id;
    private String address;
    private String district;
    private Long phone;
    public Address(String address, String district, Long phone){
        this.address = address;
        this.district = district;
        this.phone = phone;
    }

    public Address(){

    }
    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}

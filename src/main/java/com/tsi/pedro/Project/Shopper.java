package com.tsi.pedro.Project;


import javax.persistence.*;


@Entity
@Table(name ="shopper")

public class Shopper {
    //Attributes
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int shopper_id;
    private String first_name;
    private String last_name;

    public Shopper(String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Shopper(){

    }
    public int getShopper_id() {
        return shopper_id;
    }

    public void setShopper_id(int shopper_id) {
        this.shopper_id = shopper_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }



}

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
    private long credit_card;
    private int customer_id;



    public Shopper(String first_name, String last_name, long credit_card, int customer_id){
        this.first_name = first_name;
        this.last_name = last_name;
        this.credit_card = credit_card;
        this.customer_id = customer_id;
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

    public long getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(long credit_card) {
        this.credit_card = credit_card;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
}

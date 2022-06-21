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
    private long credit_card;
    private String expire_date;
    private int cvc_code;
    private Integer customer_id;




    public Shopper(String first_name,  long credit_card, String expire_date, int cvc_code, Integer customer_id){
        this.first_name = first_name;

        this.credit_card = credit_card;
        this.expire_date = expire_date;
        this.cvc_code = cvc_code;
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


    public long getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(long credit_card) {
        this.credit_card = credit_card;
    }

    public String getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }

    public int getCvc_code() {
        return cvc_code;
    }

    public void setCvc_code(int cvc_code) {
        this.cvc_code = cvc_code;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }
}

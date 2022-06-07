package com.tsi.pedro.Project;


import javax.persistence.*;

@Entity
@Table(name ="customer")

public class Customer {
    //Attributes
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int customer_id;
    private String first_name;
    private String last_name;
    private String email;

    public Customer(String first_name, String last_name, String email){
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public Customer(){

    }
    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

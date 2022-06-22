package com.tsi.pedro.Project;


import javax.persistence.*;

@Entity
@Table(name ="staff")

public class Staff {
    //Attributes
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int staff_id;
    private String first_name;
    private String last_name;
    private int address_id;
    private String email;
    private String username;
    private String password;

    public Staff(String first_name, String last_name, int address_id, String email, String username, String password){
        this.first_name=first_name;
        this.last_name=last_name;
        this.address_id=address_id;
        this.email=email;
        this.username=username;
        this.password=password;
    }

    public Staff(){

    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
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

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

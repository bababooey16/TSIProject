package com.tsi.pedro.Project;

import javax.persistence.*;

@Entity
@Table(name ="store")
public class Store {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int store_id;
    private int manager_staff_id;
    private int address_id;

    public Store(int manager_staff_id, int address_id){
        this.manager_staff_id=manager_staff_id;
        this.address_id=address_id;

    }

    public Store(){

    }
    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getManager_staff_id() {
        return manager_staff_id;
    }

    public void setManager_staff_id(int manager_staff_id) {
        this.manager_staff_id = manager_staff_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }
}

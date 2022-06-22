package com.tsi.pedro.Project;
import javax.persistence.*;

@Entity
@Table(name ="rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int rental_id;
    private int inventory_id;
    private int customer_id;
    private int staff_id;

    public Rental(int inventory_id, int customer_id, int staff_id) {
        this.inventory_id = inventory_id;
        this.customer_id = customer_id;
        this.staff_id = staff_id;

    }
    public Rental(){

    }

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    public int getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }
}
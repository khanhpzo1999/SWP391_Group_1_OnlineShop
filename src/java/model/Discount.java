/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hung tran
 */
public class Discount {
    private int id;
    private String discount_name;
    private float discount_number;

    public Discount() {
    }

    public Discount(int id) {
        this.id = id;
    }

    
    public Discount(int id, String discount_name, float discount_number) {
        this.id = id;
        this.discount_name = discount_name;
        this.discount_number = discount_number;
    }

    public Discount(String discount_name, float discount_number) {
        this.discount_name = discount_name;
        this.discount_number = discount_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscount_name() {
        return discount_name;
    }

    public void setDiscount_name(String discount_name) {
        this.discount_name = discount_name;
    }

    public float getDiscount_number() {
        return discount_number;
    }

    public void setDiscount_number(float discount_number) {
        this.discount_number = discount_number;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hung tran
 */
public class ComingProduct {
    private int id, product_quantity, category_id;
    private float product_price;
    private String product_name, product_thumbnail, product_description;
    private boolean product_status, product_coming;

    public ComingProduct() {
    }

    public ComingProduct(int id, int product_quantity, int category_id, float product_price, String product_name, String product_thumbnail, String product_description, boolean product_status, boolean product_coming) {
        this.id = id;
        this.product_quantity = product_quantity;
        this.category_id = category_id;
        this.product_price = product_price;
        this.product_name = product_name;
        this.product_thumbnail = product_thumbnail;
        this.product_description = product_description;
        this.product_status = product_status;
        this.product_coming = product_coming;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public float getProduct_price() {
        return product_price;
    }

    public void setProduct_price(float product_price) {
        this.product_price = product_price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_thumbnail() {
        return product_thumbnail;
    }

    public void setProduct_thumbnail(String product_thumbnail) {
        this.product_thumbnail = product_thumbnail;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public boolean isProduct_status() {
        return product_status;
    }

    public void setProduct_status(boolean product_status) {
        this.product_status = product_status;
    }

    public boolean isProduct_coming() {
        return product_coming;
    }

    public void setProduct_coming(boolean product_coming) {
        this.product_coming = product_coming;
    }
    
    
}

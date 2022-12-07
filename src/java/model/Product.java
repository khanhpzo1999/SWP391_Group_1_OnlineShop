/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Computer
 */
public class Product {

    private int pid;
    private String product_name;
    private float product_price;
    private boolean product_coming;
    private String product_thumbnail;
    private boolean product_status;
    private String product_description;
    private int product_quatity;
    private int category_id;

    public Product() {
    }

    public Product(int pid, String product_name, float product_price, boolean product_coming, String product_thumbnail, boolean product_status, String product_description, int product_quatity, int category_id) {
        this.pid = pid;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_coming = product_coming;
        this.product_thumbnail = product_thumbnail;
        this.product_status = product_status;
        this.product_description = product_description;
        this.product_quatity = product_quatity;
        this.category_id = category_id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(float product_price) {
        this.product_price = product_price;
    }

    public boolean isProduct_coming() {
        return product_coming;
    }

    public void setProduct_coming(boolean product_coming) {
        this.product_coming = product_coming;
    }

    public String getProduct_thumbnail() {
        return product_thumbnail;
    }

    public void setProduct_thumbnail(String product_thumbnail) {
        this.product_thumbnail = product_thumbnail;
    }

    public boolean isProduct_status() {
        return product_status;
    }

    public void setProduct_status(boolean product_status) {
        this.product_status = product_status;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public int getProduct_quatity() {
        return product_quatity;
    }

    public void setProduct_quatity(int product_quatity) {
        this.product_quatity = product_quatity;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

}

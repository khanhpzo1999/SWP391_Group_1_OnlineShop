/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Nhat Anh
 */
public class Order {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String note;
    private int status;
    private Date date;
    private int discount;
    private float total;
    private int idDiscount;
    private int user_id;

    public Order() {
    }

    public Order(String name, String email, String phone, String address, String note, int status, int discount, float total, int user_id) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.note = note;
        this.status = status;
        this.discount = discount;
        this.total = total;
        this.user_id = user_id;
    }

    public Order(String name, String email, String phone, String address, String note, int status, Date date, int discount, float total, int user_id) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.note = note;
        this.status = status;
        this.date = date;
        this.discount = discount;
        this.total = total;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(int idDiscount) {
        this.idDiscount = idDiscount;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address + ", note=" + note + ", status=" + status + ", date=" + date + ", discount=" + discount + ", total=" + total + ", idDiscount=" + idDiscount + ", user_id=" + user_id + '}';
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import model.ComingProduct;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hung tran
 */
public class DAOComingProduct extends DBContext {

    public List<ComingProduct> getAll() {
        List<ComingProduct> list = new ArrayList<>();
        String sql = "select * from Product where product_coming = 1";
        try (
                 PreparedStatement ps = connection.prepareStatement(sql);  ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                list.add(new ComingProduct(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getBoolean(4), rs.getString(5), rs.getBoolean(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ComingProduct getById(int id) {
        String sql = "select * from Product where id = " + id;
        try (
                 PreparedStatement ps = connection.prepareStatement(sql);  ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                return (new ComingProduct(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getBoolean(4), rs.getString(5), rs.getBoolean(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void insert(ComingProduct p) {
        String sql = "insert into Product(product_name,product_price,product_coming,product_thumbnail,product_status,product_description,product_quantity,category_id) values(?,?,?,?,?,?,?,?)";
        try (
                 PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setString(1, p.getProduct_name());
            ps.setFloat(2, (float) p.getProduct_price());
            ps.setBoolean(3, true);
            ps.setString(4, p.getProduct_thumbnail());
            ps.setBoolean(5, false);
            ps.setString(6, p.getProduct_description());
            ps.setInt(7, p.getProduct_quatity());
            ps.setInt(8, p.getCategory_id());

            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void update(ComingProduct p) {
        String sql = "update Product set product_name = ?, product_price = ?, product_coming = ?, product_thumbnail = ?, product_status = ?, product_description = ?, product_quantity = ?, category_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, p.getProduct_name());
            ps.setFloat(2, (float) p.getProduct_price());
            ps.setBoolean(3, p.isProduct_coming());
            ps.setString(4, p.getProduct_thumbnail());
            ps.setBoolean(5, p.isProduct_status());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void delete(String id) {
        String sql = "delete from Product where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public static void main(String[] args) {
        try {
            List<ComingProduct> list = new DAOComingProduct().getAll();
            for (ComingProduct p : list) {
                System.out.println(p.getProduct_name());
                System.out.println(p.getProduct_price());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

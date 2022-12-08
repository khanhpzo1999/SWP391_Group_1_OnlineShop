/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import model.Discount;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hung tran
 */
public class DAODiscount extends DBContext {

    public List<Discount> getAll() {
        List<Discount> list = new ArrayList<>();
        String sql = "select * from Discount order by discount_number";
        try (
                 PreparedStatement ps = connection.prepareStatement(sql);  ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                list.add(new Discount(rs.getInt(1), rs.getString(2), rs.getFloat(3)));
            }
        } catch (SQLException ex) {
        }
        return list;
    }

    public Discount getById(int id) {
        String sql = "select * from Discount where id = " + id;
        try (
                 PreparedStatement ps = connection.prepareStatement(sql);  ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {
                return (new Discount(rs.getInt(1), rs.getString(2), rs.getFloat(3)));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public List<Discount> getByPage(List<Discount> list, int page) {
        List<Discount> dis = new ArrayList<>();
        int discountPerPage = 9;
        int start = (page * discountPerPage) - discountPerPage;
        int end;
        if (list.size() < page * discountPerPage) {
            end = list.size();
        } else {
            end = discountPerPage * page;
        }
        for (int i = start; i < end; i++) {
            dis.add(list.get(i));
        }
        return dis;
    }

    public void insert(Discount dis) {
        List<Discount> list = new DAODiscount().getAll();
        for (Discount d : list) {
            if (d.getDiscount_name().equalsIgnoreCase(dis.getDiscount_name())) {
                return;
            }
        }
        String sql = "insert into Discount (discount_name, discount_number) values(?, ?)";
        try (
                 PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setString(1, dis.getDiscount_name());
            ps.setFloat(2, dis.getDiscount_number());
            ps.executeUpdate();
        } catch (SQLException e) {
            return;
        }
        return;
    }

    public void update(Discount dis) {
        String sql = "update Discount set discount_name = ?, discount_number = ? where id = ?";
        try (
                 PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setString(1, dis.getDiscount_name());
            ps.setFloat(2, dis.getDiscount_number());
            ps.setInt(3, dis.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void delete(String id) {
        String sql = "delete from Discount where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public static void main(String[] args) {
        try {
            List<Discount> list = new DAODiscount().getAll();
            for (Discount d : list) {
                System.out.println(d.getDiscount_name());
                System.out.println(d.getDiscount_number());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author admin
 */
public class UserDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public User userRegister(String username, String password) {
        String query = "Insert into Users(user_name, password, role_id) values(?,?,1)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();

        } catch (Exception e) {

        }
        return null;
    }

    public User checkAccountExist(String username) {
        String query = "Select * from Users where user_name=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getString(2),
                        rs.getString(3)
                );

            }
        } catch (Exception e) {
        }
        return null;
    }

    public User login(String username, String password) {
        String query = "Select * from Users where user_name=? and password=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(8));

            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<User> getListUser() {
        List<User> listUser = new ArrayList<>();
        String query = "Select * from Users";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                listUser.add(new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)
                ));
            }
        } catch (Exception e) {
        }
        return listUser;
    }

    public User getUserById(String id) {
        String query = "SELECT * FROM Users where id = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void deleteUser(String id) {
        String query = "Delete from Users where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    // long
    
//    public static void main(String[] args) throws Exception {
//        UserDAO dao = new UserDAO();
//        List<User> list = dao.getUserInformation(2);
//        for (User product : list) {
//            System.out.println(product.getUser_phone());
//        }
//    }
    public List<User> getUserInformation(int id) {
        List<User> UserInfo = new ArrayList<>();
        String query = "select * from Users\n"
                + "where id= ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserInfo.add(new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)
                ));
            }
        } catch (Exception e) {
        }
        return UserInfo;
    }
    
   
}

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
}

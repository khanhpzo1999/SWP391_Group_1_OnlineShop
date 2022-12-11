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
import model.Feedback;

/**
 *
 * @author admin
 */
public class FeedbackDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Feedback addFeedback(String fullname, String email, String address, String phone, String feedback) {
        String query = "Insert into Feedback(feedback_fullname, fullname_email, fullname_address ,fullname_phone , fullname_message) values(?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, fullname);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, phone);
            ps.setString(5, feedback);
            ps.executeUpdate();

        } catch (Exception e) {

        }
        return null;
    }
}

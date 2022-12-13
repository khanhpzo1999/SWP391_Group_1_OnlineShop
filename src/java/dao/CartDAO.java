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

/**
 *
 * @author Nhat Anh
 */
public class CartDAO {
    private Connection connection = null;
    
    public int countItem(int userId) throws Exception {
        int count = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        connection = (new DBContext().connection);
        
        String sql = "";
        
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            
        }catch(Exception e) {
            
        }
        
        return 0;
    }
}

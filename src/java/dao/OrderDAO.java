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
import java.sql.Statement;
import java.util.ArrayList;
import model.Cart;
import model.Order;
import model.OrderDetail;

/**
 *
 * @author Nhat Anh
 */
public class OrderDAO {

    private Connection connection = null;

    public int insertOrder(Order order, ArrayList<Cart> cart) throws Exception {
        String order_sql = "INSERT INTO [dbo].[Order]\n"
                + "           ([order_fullname]\n"
                + "           ,[order_email]\n"
                + "           ,[order_phone]\n"
                + "           ,[order_address]\n"
                + "           ,[order_note]\n"
                + "           ,[order_status]\n"
                + "           ,[order_date]\n"
                + "           ,[order_discount]\n"
                + "           ,[total_money]\n"
                + "           ,[user_id])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,0,GETDATE(),?,?,?)";
        PreparedStatement ps = null;
        connection = (new DBContext().connection);
        try {
            ps = connection.prepareStatement(order_sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, order.getName());
            ps.setString(2, order.getEmail());
            ps.setString(3, order.getPhone());
            ps.setString(4, order.getAddress());
            ps.setString(5, order.getNote());
            ps.setInt(6, order.getDiscount());
            ps.setFloat(7, order.getTotal());
            ps.setInt(8, order.getUser_id());

            int check = ps.executeUpdate();

            if (check == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                int order_id = 0;
                while (rs.next()) {
                    order_id = rs.getInt(1);
                }

                if (order_id > 0) {
                    String order_detail_sql = "INSERT INTO [dbo].[Order_detail]\n"
                                + "           ([order_id]\n"
                                + "           ,[product_id]\n"
                                + "           ,[quantity])\n"
                                + "     VALUES\n"
                                + "           (?,?,?)";
                    ps = connection.prepareStatement(order_detail_sql);
                    for (Cart item : cart) {
                        ps.setInt(1, order_id);
                        ps.setInt(2, item.getProduct().getPid());
                        ps.setInt(3, item.getQuantity());
                        ps.executeUpdate();
                    }
                }
            }

            return check;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    public Order getOne(int id){
        String sql = "Select * from [dbo].[Order] WHERE id = " + id;
        PreparedStatement ps = null;
        connection = (new DBContext().connection);
        try {
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Order o = null;
            while(rs.next()){
                o = new Order(
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getInt(7),
                    rs.getDate(8),
                    rs.getInt(9),
                    rs.getFloat(10),
                    rs.getInt(11)
                );
            }
            return o;
        } catch (Exception e) {
        }
        return null;
    }
    
    public ArrayList<OrderDetail> getOrderDetail(int id){
        String sql = "Select * from [dbo].[Order_detail] WHERE order_id = " + id;
        ArrayList<OrderDetail> list = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                OrderDetail od = new OrderDetail(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
                list.add(od);
            }
            return list;
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        OrderDAO dao = new OrderDAO();
        Order order = new Order(
                "fdfd", "fdfdf", "fdfdfd", "fdfdf", "xcxcx", 0, 30, 234, 1);

        try {
//            dao.insertOrder(order);
        } catch (Exception e) {
        }
    }
}

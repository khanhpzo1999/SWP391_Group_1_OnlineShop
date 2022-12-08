/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

/**
 *
 * @author Computer
 */
public class ProductDAO {

    private Connection connection = null;

    public ArrayList<Product> getAllProduct() throws Exception {
        ArrayList<Product> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        connection = (new DBContext().connection);
        String sql = "select id, product_name, product_description, product_quantity, product_price from dbo.Product";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setPid(rs.getInt("id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setProduct_description(rs.getString("product_description"));
                product.setProduct_quatity(rs.getInt("product_quantity"));
                product.setProduct_price(rs.getFloat("product_price"));
                list.add(product);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getProductBypage(List<Product> list, int page) {
        List<Product> arr = new ArrayList<>();
        int productPerPage = 9;
        int start = (page * productPerPage) - productPerPage;
        int end;
        if (list.size() < page * productPerPage) {
            end = list.size();
        } else {
            end = productPerPage * page;
        }
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;

    }

//    public static void main(String[] args) throws Exception {
//        ProductDAO dao = new ProductDAO();
//        ArrayList<Product> list = dao.getAllProduct();
//        for (Product product : list) {
//            System.out.println(product.getProduct_name());
//        }
//    }
}

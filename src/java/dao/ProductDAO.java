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
import model.Category;
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

    public static void main(String[] args) throws Exception {
        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.getListComingProduct();
        for (Product product : list) {
            System.out.println(product.getCategory_id());
        }
    }
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getProductDetail(int product_id) {
        List<Product> ListProduct = new ArrayList<>();
        String query = "select *\n"
                + "from Product, Category\n"
                + "where Product.category_id = Category.id and Product.id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, product_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                ListProduct.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getBoolean(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(11)
                ));
            }
        } catch (Exception e) {
        }
        return ListProduct;
    }

    public List<Product> getListComingProduct() {
        List<Product> ListComingProduct = new ArrayList<>();
        String query = "select * from Product\n"
                + "where product_coming = 'true'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                ListComingProduct.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getBoolean(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9)
                    
                ));
            }
        } catch (Exception e) {
        }
        return ListComingProduct;
    }

}

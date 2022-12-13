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
        String sql = "select id, "
                + "product_name, "
                + "product_description, "
                + "product_quantity, "
                + "product_price "
                + "from dbo.Product";
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
    
    public ArrayList<Product> searchProduct(String name, boolean isComing) throws Exception {
        ArrayList<Product> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        connection = (new DBContext().connection);
        String sql = "select id, "
                + "product_name, "
                + "product_description, "
                + "product_quantity, "
                + "product_price, product_thumbnail "
                + "from dbo.Product WHERE product_name LIKE '%" + name + "%' AND product_coming = " + (isComing ? "1" : "0") ;
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
                product.setProduct_thumbnail(rs.getString("product_thumbnail"));
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

    public void addProduct(String name, float price, String thumbnail, String description, int quantity, int id) {
        String sql = "INSERT INTO [dbo].[Product]\n"
                + "           ([product_name]\n"
                + "           ,[product_price]\n"
                + "           ,[product_coming]\n"
                + "           ,[product_thumbnail]\n"
                + "           ,[product_status]\n"
                + "           ,[product_description]\n"
                + "           ,[product_quantity]\n"
                + "           ,[category_id])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setFloat(2, price);
            ps.setBoolean(3, false);
            ps.setString(4, thumbnail);
            ps.setBoolean(5, true);
            ps.setString(6, description);
            ps.setInt(7, quantity);
            ps.setInt(8, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(String name) {
        String sql = "Delete from Product where product_name = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(String name, float price, String description, int id) {
        String sql = "UPDATE [dbo].[Product]\n"
                + "   SET [product_name] = ?\n"
                + "      ,[product_price] = ?\n"
                + "      ,[product_description] = ?\n"
                + " WHERE [id] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setFloat(2, price);
            ps.setString(3, description);
            ps.setInt(4, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> getProductManagementList() {
        List<Product> list = new ArrayList<>();
        String sql = "select P.id, product_name, product_price, product_quantity, category_name\n"
                + "from Product P join Category C \n"
                + "on P.category_id = C.id";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getInt(4),
                        rs.getString(5)));
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Product getProductByName(int pid) {
        String sql = "select * from Product where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getBoolean(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Product getOne(int pid) {
        String sql = "select * from Product where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getBoolean(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        ProductDAO dao = new ProductDAO();
        ArrayList<Product> list = dao.searchProduct("Nike",true);
//        System.out.println(list);
    }

    public List<Product> getProductComingDetail(int product_id) {
        List<Product> ListProduct = new ArrayList<>();
        String query = "select * from \n"
                + "Product,Category\n"
                + "where  Product.category_id =  Category.id and product_coming = 'true' and Product.id = ?";
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
}

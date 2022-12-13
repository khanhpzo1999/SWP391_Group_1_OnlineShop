package dao;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Product;

public class CategoryDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Category> getListCategory() {
        List<Category> listCategory = new ArrayList<>();
        String query = "Select * from Category";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                listCategory.add(new Category(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }
        } catch (Exception e) {
        }
        return listCategory;
    }

    public List<Product> getProductByCategory(int categoryId) {
        List<Product> listProduct = new ArrayList<>();
        String query = "Select * from Product where category_id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();
            while (rs.next()) {
                listProduct.add(new Product(
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
        return listProduct;
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

    public Category getCategoryById(int id) {
        String query = "SELECT * FROM Category where id = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Category(
                        rs.getInt(1),
                        rs.getString(2)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void updateCategory(String category_name, int id) {
        String query = "update Category set category_name = ? where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, category_name);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    public void deleteCategory(String id) {
        String query = "Delete from Category where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Category addCategory(String category_name) {
        String query = "Insert into Category(category_name) values(?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, category_name);
            ps.executeUpdate();

        } catch (Exception e) {

        }
        return null;
    }

}

package br.com.exactalabs.bicycleshop.repository;

import br.com.exactalabs.bicycleshop.entity.Page;
import br.com.exactalabs.bicycleshop.entity.ProductCategory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ProductCategoryRepository {

    private static final String TABLE_NAME = "product_category";
    private final Connection connection;

    public ProductCategoryRepository() {
        try {
            this.connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/bicycle_shop", "root", "root");
            System.out.println("Conexão aberta");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ProductCategory insert(ProductCategory productCategory) {
        try {
            String sql = "INSERT INTO " + TABLE_NAME + " (description, created_at) VALUES (?, ?)";

            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setString(1, productCategory.getName());
            stmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));

            stmt.execute();
            stmt.close();
            return productCategory;
        } catch (Exception ex) {
            System.out.println(ex);
            throw new RuntimeException(ex);
        }
    }

    public ProductCategory findById(Long id) {
        try {
            String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";

            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, id);

            ResultSet result = stmt.executeQuery();

            while (result.next()) {

                ProductCategory productCategory = this.createCategory(result);
                result.close();

                return productCategory;
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    public void batchInsert(Collection<ProductCategory> productCategories) {
        productCategories.forEach(this::insert);
    }

    public ProductCategory update(ProductCategory productCategory) {
        try {
            String sql = "UPDATE " + TABLE_NAME + " SET description = ?, updated_at = ? WHERE id = ?";

            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setString(1, productCategory.getName());
            stmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            stmt.setLong(3, productCategory.getId());

            stmt.execute();
            stmt.close();

            return this.findById(productCategory.getId());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void delete(Long id) {
        try {
            var sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";

            var stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Collection<ProductCategory> findAll() {
        var productCategories = new ArrayList<ProductCategory>();
        try {
            String sql = "SELECT * FROM " + TABLE_NAME;

            PreparedStatement stmt = this.connection.prepareStatement(sql);

            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                productCategories.add(this.createCategory(result));
            }
            result.close();

            return productCategories;


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Page<ProductCategory> findAllPaged(int pageNumber, int pageSize) {
        var productCategories = new ArrayList<ProductCategory>();
        try {
            String sql = "SELECT * FROM " + TABLE_NAME + " LIMIT ? OFFSET ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, pageSize);
            var offset = pageSize * (pageNumber - 1);
            stmt.setInt(2, offset);

            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                productCategories.add(this.createCategory(result));
            }
            result.close();

            var page = new Page<ProductCategory>();
            page.setPageNumber(pageNumber);
            page.setResults(productCategories);
            page.setTotalPages(this.countTotalPages(pageSize));

            return page;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private Integer countTotalPages(Integer pageSize) {
        try {
            var sql = "SELECT CEIL(COUNT(*) / ?) FROM " + TABLE_NAME;
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, pageSize);

            var result = stmt.executeQuery();

            while (result.next()) {

                var totalPages = result.getInt(1);

                result.close();
                return totalPages;

            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return 0;
    }

    private ProductCategory createCategory(ResultSet result) throws SQLException {
        var idResult = result.getLong("id");
        var descriptionResult = result.getString("description");

        var productCategory = new ProductCategory();
        productCategory.setId(idResult);
        productCategory.setName(descriptionResult);
        return productCategory;
    }

}

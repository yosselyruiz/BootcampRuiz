package org.yearup.data.mysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao {
    @Autowired //had to add this
    public MySqlCategoryDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM categories";
        try(
                Connection conn = getConnection(); //had to change this b/c MySqlCategoryDao extends MySqlDaoBase.
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()){

            while (rs.next()) {
                Category c = mapRow(rs);
                categories.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    @Override
    // get category by id
    public Category getById(int categoryId) {
        String sql = "SELECT * FROM categories WHERE category_id = ?";

        try(Connection conn = getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryId);

            ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        catch(SQLException ex){
            ex.printStackTrace();
        }

        return null;
    }
    @Override
    // create a new category
    public Category create(Category category) {
        String sql = "INSERT INTO categories"+ "(name, description)" + "VALUES (?,?)";
        try(Connection conn = getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,category.getName());
            stmt.setString(2,category.getDescription());

            int rowsInserted = stmt.executeUpdate();
            if(rowsInserted > 0){
                ResultSet keys = stmt.getGeneratedKeys();

                    if(keys.next()) {
                        int categoryId = keys.getInt(1);
                        return getById(categoryId);
                    }
                }
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    @Override
    // update category
    public void update(int categoryId, Category category) {
        String sql = "UPDATE categories SET name = ?, description = ? WHERE category_id = ?";
        try(Connection conn = getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());
            stmt.setInt(3, categoryId);

            stmt.executeUpdate();
        }
        catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    // delete category
    public void delete(int categoryId) {
        String sql = "DELETE FROM categories " +
                "WHERE category_id = ?";

        try(Connection conn = getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryId);

            stmt.executeUpdate();
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    private Category mapRow(ResultSet row) throws SQLException {
        int categoryId = row.getInt("category_id");
        String name = row.getString("name");
        String description = row.getString("description");

        Category category = new Category()
        {{
            setCategoryId(categoryId);
            setName(name);
            setDescription(description);
        }};

        return category;
    }

}

package org.yearup.data.mysql;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class MySqlDaoBase {

    private DataSource dataSource;

    public MySqlDaoBase(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }
    //This means any subclass (like MySqlCategoryDao) can simply call getConnection()
    // to work with the database, without duplicating boilerplate code.
    protected Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}

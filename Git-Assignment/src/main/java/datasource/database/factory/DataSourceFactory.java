package datasource.database.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

/**
 *
 * @author Islam El-Rougy
 */
public class DataSourceFactory
{

    public static DataSource getMySQLDataSource()
    {
        MysqlDataSource mySqlDataSource = null;
        mySqlDataSource = new MysqlDataSource();
        mySqlDataSource.setURL("jdbc:mysql://localhost:3306/hr");
        mySqlDataSource.setUser("root");
        mySqlDataSource.setPassword("THOK_AFC2018");

        return mySqlDataSource;
    }
}

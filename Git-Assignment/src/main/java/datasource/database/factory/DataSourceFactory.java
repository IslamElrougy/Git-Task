
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
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        MysqlDataSource mySqlDataSource = null;
        try 
        {
            fileInputStream = new FileInputStream("C:\\Users\\Islam El-Rougy\\Documents\\NetBeansProjects\\DataSource First Project\\database.properties");
            properties.load(fileInputStream);
            mySqlDataSource = new MysqlDataSource();
            mySqlDataSource.setURL(properties.getProperty("MYSQL_DB_URL"));
            mySqlDataSource.setUser(properties.getProperty("MYSQL_DB_USERNAME"));
            mySqlDataSource.setPassword(properties.getProperty("MYSQL_DB_PASSWORD"));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return mySqlDataSource;
    }
}

package cn.chen.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/***
 * JDBC utils using Druid Connection pool
 */
public class JDBCUtils {

    private static DataSource ds;

    static {

        try {
            // 1.  load .properties file
            Properties pro = new Properties();
            //use classloader get .properties file, get inputStream
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);

            // 2.  initialize connection pool object
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * get the connnection pool object
     */
    public static DataSource getDataSource(){
        return ds;
    }

    /**
     * get connection object
     */
    public static Connection getConnection() throws SQLException
    {
        return ds.getConnection();
    }


}

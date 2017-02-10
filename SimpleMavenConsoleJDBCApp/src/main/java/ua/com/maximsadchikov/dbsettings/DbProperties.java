package ua.com.maximsadchikov.dbsettings;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbProperties {

    public final static String DB_URL;
    public final static String DB_USER;
    public final static String DB_PASSWORD;

    static {
        InputStream is = DbProperties.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        DB_URL = properties.getProperty("dbUrl");
        DB_USER = properties.getProperty("dbUser");
        DB_PASSWORD = properties.getProperty("dbPassword");
    }

    private DbProperties() {
    }
}

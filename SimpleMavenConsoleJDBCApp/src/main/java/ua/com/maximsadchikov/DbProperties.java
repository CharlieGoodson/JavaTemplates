package ua.com.maximsadchikov;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbProperties {

    private String dbUrl;
    private String dbUser;
    private String dbPassword;

    private static DbProperties instance = null;

    private DbProperties() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("db.properties");
        Properties prts = new Properties();
        try {
            prts.load(is);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        dbUrl = prts.getProperty("dbUrl");
        dbUser = prts.getProperty("dbUser");
        dbPassword = prts.getProperty("dbPassword");
    }

    public static DbProperties getInstance() {
        if (instance == null) {
            instance = new DbProperties();
            return instance;
        } else {
            return instance;
        }
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }
}

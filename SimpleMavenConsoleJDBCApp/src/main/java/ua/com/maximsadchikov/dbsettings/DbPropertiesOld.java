package ua.com.maximsadchikov.dbsettings;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbPropertiesOld {

    private String dbUrl;
    private String dbUser;
    private String dbPassword;

    private static DbPropertiesOld instance = null;

    private DbPropertiesOld() {
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

    public static DbPropertiesOld getInstance() {
        if (instance == null) {
            instance = new DbPropertiesOld();
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

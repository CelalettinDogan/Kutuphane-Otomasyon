package proje1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class cVeritabani implements DatabasePlatform {
    public static int _kullaniciId;
    public static int _uyeId;
    public Connection configureConnection() {
        String sqlCon = "jdbc:sqlserver://DESKTOP-VAIT1B1\\SQLEXPRESS;Database=Kutuphane;IntegratedSecurity=true";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(sqlCon);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

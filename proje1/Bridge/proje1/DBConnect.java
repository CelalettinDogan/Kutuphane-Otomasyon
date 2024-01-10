package proje1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect implements Database {
	private final DatabasePlatform platform;

    DBConnect(DatabasePlatform platform) {
        this.platform = platform;
    }

    @Override
    public Connection baglanti() {
        Connection connection = platform.configureConnection();
      
		return connection;
    }



  
}


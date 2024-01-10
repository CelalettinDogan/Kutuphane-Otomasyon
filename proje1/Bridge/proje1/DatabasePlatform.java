package proje1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DatabasePlatform {
    Connection configureConnection();
}

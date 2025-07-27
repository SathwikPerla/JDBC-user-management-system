
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/hiring_platform";
        String user = "root";
        String password = "eabs1234"; // password

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}

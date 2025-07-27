package operations;

import java.sql.*;

public class FetchUsers {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hiring_platform";
        String user = "root";
        String password = "eabs1234";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM user";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("---------- Users ----------");

            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("ID      : " + rs.getInt("user_id"));
                System.out.println("Name    : " + rs.getString("name"));
                System.out.println("Email   : " + rs.getString("email"));
                System.out.println("DOB     : " + rs.getDate("dateOfBirth"));
                System.out.println("--------------------------");
            }

            if (!found) {
                System.out.println("❌ No users found in the database.");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package operations;

import java.sql.*;
import java.util.Scanner;

public class FetchUserById {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter User ID to fetch: ");
        int userId = sc.nextInt();

        String url = "jdbc:mysql://localhost:3306/hiring_platform";
        String user = "root";
        String password = "eabs1234";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM user WHERE user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("---------- User Details ----------");
                System.out.println("ID: " + rs.getInt("user_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Gender: " + rs.getString("gender"));
                System.out.println("Phone: " + rs.getString("phoneNo"));
                System.out.println("DOB: " + rs.getDate("dateOfBirth"));
                System.out.println("Password: " + rs.getString("password"));
                System.out.println("----------------------------------");
            } else {
                System.out.println("❌ No user found with ID: " + userId);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}

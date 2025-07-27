package operations;
import java.sql.*;
import java.util.Scanner;

public class DeleteUser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter User ID to delete: ");
        int userId = sc.nextInt();

        String url = "jdbc:mysql://localhost:3306/hiring_platform";
        String user = "root";
        String password = "eabs1234";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "DELETE FROM user WHERE user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, userId);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ User deleted successfully.");
            } else {
                System.out.println("❌ No user found with that ID.");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}

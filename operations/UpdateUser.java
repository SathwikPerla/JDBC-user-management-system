package operations;
import java.sql.*;
import java.util.Scanner;

public class UpdateUser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter User ID to update: ");
        int userId = sc.nextInt();
        sc.nextLine(); // this line is to clear the buffer

        System.out.print("Enter new name: ");
        String newName = sc.nextLine();

        System.out.print("Enter new phone number: ");
        String phoneNo = sc.nextLine();

        System.out.print("Enter new password: ");
        String newPassword = sc.nextLine();

        String url = "jdbc:mysql://localhost:3306/hiring_platform";
        String user = "root";
        String password = "eabs1234";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "UPDATE user SET name = ?, phoneNo = ?, password = ? WHERE user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, newName);
            pstmt.setString(2, phoneNo);
            pstmt.setString(3, newPassword);
            pstmt.setInt(4, userId);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ User updated successfully.");
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

package operations;

import java.sql.*;
import java.util.Scanner;

public class InsertUser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter User ID: ");
        int user_id = sc.nextInt();
        sc.nextLine(); // this is for clearing newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Gender (MALE/FEMALE/OTHERS): ");
        String gender = sc.nextLine();
        System.out.print("Enter Phone No: ");
        String phone = sc.nextLine();
        System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
        String dob = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hiring_platform", "root", "eabs1234");

            String sql = "INSERT INTO user (user_id, name, email, gender, phoneNo, dateOfBirth, password) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user_id);
            stmt.setString(2, name);
            stmt.setString(3, email);
            stmt.setString(4, gender);
            stmt.setString(5, phone);
            stmt.setDate(6, Date.valueOf(dob));
            stmt.setString(7, password);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ User inserted successfully.");
            } else {
                System.out.println("❌ Failed to insert user.");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}

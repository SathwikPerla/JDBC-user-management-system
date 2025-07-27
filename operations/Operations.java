package operations;
import java.sql.*;

public class Operations {

    public static void fetchAllUsers(Connection conn) throws SQLException {
        String sql = "SELECT * FROM user";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("user_id") +
                    ", Name: " + rs.getString("name") +
                    ", Email: " + rs.getString("email"));
        }
    }

    public static void insertUser(Connection conn, int id, String name, String email, String gender,
            String phone, String dob, String password) throws SQLException {
        String sql = "INSERT INTO user (user_id, name, email, gender, phoneNo, dateOfBirth, password) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.setString(3, email);
        pstmt.setString(4, gender);
        pstmt.setString(5, phone);
        pstmt.setDate(6, Date.valueOf(dob));
        pstmt.setString(7, password);

        int rows = pstmt.executeUpdate();
        System.out.println("✅ " + rows + " user(s) inserted.");
    }
}

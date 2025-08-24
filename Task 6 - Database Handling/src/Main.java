import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // Database credentials
        String jdbcURL = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "Krishna";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            conn = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to database.");
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "name VARCHAR(100) NOT NULL, "
                    + "email VARCHAR(100) UNIQUE NOT NULL)";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'users' created or already exists.");
            String insertSQL = "INSERT INTO users (name, email) VALUES (?, ?)";
            pstmt = conn.prepareStatement(insertSQL);

            pstmt.setString(1, "Krishna");
            pstmt.setString(2, "krishna@example.com");
            pstmt.executeUpdate();

            pstmt.setString(1, "Abhay");
            pstmt.setString(2, "abhay@example.com");
            pstmt.executeUpdate();

            System.out.println("Data inserted successfully.");

            // Step 3: Fetch data
            String selectSQL = "SELECT * FROM users";
            rs = stmt.executeQuery(selectSQL);

            System.out.println("Fetching records from users table:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println(id + " | " + name + " | " + email);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }
}

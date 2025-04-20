import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeRepository {

    private String userDB = "root";
    private String passDB = "1234";
    private String dbName = "incedojuly24";
    private String url = "jdbc:mysql://localhost:3306/";
    private String driver = "com.mysql.cj.jdbc.Driver";

    private Connection conn;

    public Connection dbConnect() {
        /* Step 1: Load the driver */
        try {
            Class.forName(driver);
            System.out.println("Driver loaded.. ");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver loading error..." + e.getMessage());
        }

        // Step 2: Establish the connection
        try {
            conn =   DriverManager.getConnection(url + dbName, userDB, passDB);
            System.out.println("Connection Successful");
        } catch (SQLException e) {
            System.out.println("Connection Issue..." + e.getMessage());
        }
        return conn;
    }

    public void dbClose() {
        try {
            conn.close();
            System.out.println("Conn close successful");
        } catch (SQLException e) {
            System.out.println("conn close error..." + e.getMessage());
        }
    }

    public static void main(String[] args) {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeRepository.dbConnect();
        employeeRepository.dbClose();
    }
}
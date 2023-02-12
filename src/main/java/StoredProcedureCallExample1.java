import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StoredProcedureCallExample1 {
public static void main(String[] args) {
String dbURL = "jdbc:mysql://localhost:3306/booksdb";
String user = "root";
String password = "P@ssw0rd";
try (
Connection conn = DriverManager.getConnection(dbURL, user, password);
CallableStatement statement = conn.prepareCall("{call create_author(?, ?)}");
) {
statement.setString(1, "Bill Gates");
statement.setString(2, "bill@microsoft.com");
statement.execute();
statement.close();
System.out.println("Stored procedure called successfully!");
} catch (SQLException ex) {
ex.printStackTrace();
}
}
}
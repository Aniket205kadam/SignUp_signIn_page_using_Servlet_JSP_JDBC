package App.Registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUtil {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Driver is registered");
	}
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/servlet";
		String name = "root";
		String password = "2004";
		return DriverManager.getConnection(url, name, password);
	}
	
	public static void close(Connection connection, PreparedStatement statement) {
		try {
			if(connection != null && statement != null) {
			connection.close();
			statement.close();
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

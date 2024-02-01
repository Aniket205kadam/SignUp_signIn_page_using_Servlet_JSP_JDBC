package App.Registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Model {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	
	private String name;
	private String email;
	private String password;
	private String city;
	int rowsAffected;
	
	public Model(String name, String email, String password, String city) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
	}
	public int register() {
		
		try {
			connection = JdbcUtil.getConnection();
			
			String query = "INSERT INTO personalinfo (Uname, Email, password, Ucity) VALUE (?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, city);
			
			rowsAffected = preparedStatement.executeUpdate();
			
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//close the resoures
			JdbcUtil.close(connection, preparedStatement);
		}
		
		return rowsAffected;
	}
	
}

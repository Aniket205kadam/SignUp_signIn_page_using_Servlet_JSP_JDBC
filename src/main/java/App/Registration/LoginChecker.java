package App.Registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginChecker {
	//user-name
	private String name = null;
	//user enter password
	private String password = null;
	
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	
	public LoginChecker(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public int login() {
		int pass_code = 0;
		
		try {
			
			connection = JdbcUtil.getConnection();
			
			String query = "SELECT password FROM personalinfo WHERE Uname = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, name);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			//user is exist
			if(resultSet.next()) {
				
				String db_password = resultSet.getString("password");
				
				//check the password
				if (db_password.equals(password)) {
					//password correct
					pass_code = 2;
				} 
				else {
					//password wrong
					pass_code = -2;
				}
			}
			//user name is not exist
			else {
				//user name not exist to the database
				pass_code = -3;
			}
			
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return pass_code;
	}
}

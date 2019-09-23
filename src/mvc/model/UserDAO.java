package mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	private Connection connection = null;
	String url = System.getenv("mysql_url");
	String user = System.getenv("mysql_user");
	String password = System.getenv("mysql_password");

	public UserDAO() throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean verificationC(User user) {
		boolean st = false;
		String sql = "SELECT * FROM login WHERE login=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getLogin());
			System.out.print(user.getLogin());
			ResultSet rs = stmt.executeQuery();
			st = rs.next();
			stmt.execute();
			stmt.close();
			return st;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return st;
		}
	}
	
	public boolean verificationL(User user) {
		boolean st = false;
		String sql = "SELECT * FROM login WHERE login=? and password=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getPassword());
			ResultSet rs = stmt.executeQuery();
			st = rs.next();
			stmt.execute();
			stmt.close();
			System.out.println(user.getLogin());

			System.out.println(user.getPassword());
			System.out.println(st);
			return st;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return st;
		}
	}
	
	public String getLogado(User user) throws SQLException {
		String sql = "SELECT * FROM login WHERE login=? and password=?";
		PreparedStatement stmt;
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getPassword());
			ResultSet rs = stmt.executeQuery();
			String login = null;
			
			if (rs.next()) {
				login = rs.getString("login");
			}
			stmt.execute();
			stmt.close();
			return login;
		
	}
	
	public void postUser(User user) {
		
		String sql = "INSERT INTO login (login, password) values(?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getPassword());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

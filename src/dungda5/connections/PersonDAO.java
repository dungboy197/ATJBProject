package dungda5.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PersonDAO {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		String hostName = "localhost";
		String dbName = "JavaWeb";
		String userName = "sa";
		String password = "Abcde12345678";
		return getConnection(hostName, dbName, userName, password);
	}

	public static Connection getConnection(String hostName, String dbName, String userName, String password)
			throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String connURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		Connection conn = DriverManager.getConnection(connURL, userName, password);
		return conn;
	}

}

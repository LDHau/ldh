package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	public Connection getConnect() throws Exception {
		Connection cn;
		final String url = "jdbc:mysql://localhost:3306/db_book";
		final String user = "root";
		final String password = "1234";
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn = DriverManager.getConnection(url, user, password);
		System.out.println("Da ket noi toi CSDL");
		return cn;
	}
}

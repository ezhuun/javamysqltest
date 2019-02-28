package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBOpen {
	static {
		try {
			Class.forName(Constant.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection open() {

		Connection con = null;

		try {
			con = DriverManager.getConnection(Constant.URL, Constant.USER, Constant.PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}
}

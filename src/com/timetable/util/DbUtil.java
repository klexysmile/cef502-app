package com.timetable.util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
	private static Connection connection = null;
	public static Connection getConnection() {
	if (connection != null)
	return connection;
	else {
		try {
//			Properties prop = new Properties();
//			InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");
//			prop.load(inputStream);
			//String driver = prop.getProperty("driver");
			String driver = "com.mysql.jdbc.Driver";
			//String url = prop.getProperty("url");
			String url = "jdbc:mysql://localhost:3306/jeetimetable";
			//String user = prop.getProperty("user");
			String user = "root";
			//String password = prop.getProperty("password");
			String password = "";
			Class.forName(driver);
			//new com.mysql.jdbc.Driver();
			connection = DriverManager.getConnection(url, user, password);
		} /*catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connection: " + connection.toString());
		return connection;
		}
	}
}

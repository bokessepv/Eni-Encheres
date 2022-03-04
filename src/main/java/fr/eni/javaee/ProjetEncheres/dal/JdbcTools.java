package fr.eni.javaee.ProjetEncheres.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//Classe qui se charge de la connection
public class JdbcTools {
	private static String urldb;
	private static String userdb;
	private static String passworddb;
	
	//initialisation static
	static {
		try {
			Class.forName(Settings.getProperty("driverdb"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		urldb = Settings.getProperty("urldb");
		userdb = Settings.getProperty("userdb");
		passworddb = Settings.getProperty("passworddb");
	}
	
	public static Connection getConnection() throws SQLException{
		Connection connection = DriverManager.getConnection(urldb, userdb, passworddb);
		return connection;
	}

}

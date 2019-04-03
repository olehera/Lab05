package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	public static Connection getConnection() {
		String jdbcURL = "jdbc:mysql://localhost/dizionario?serverTimezone=UTC&user=root&password=sascia";
		
		try {
		Connection conn = DriverManager.getConnection(jdbcURL); 
		
		return conn;
		
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

}

package com.bemach.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
	private static Logger logger = Logger.getLogger(DatabaseConnection.class.getName());
	private static String databaseDriver;
	private static String databaseUrl;
	private static String databaseUser;
	private static String databasePassword;
	
	public static void initialize (String databaseConnectionPropertiesFile) {
		File propertiesFile = new File(databaseConnectionPropertiesFile);
		try {
			FileReader fileReader = new FileReader(propertiesFile);
			Properties databaseProperties = new Properties();
			databaseProperties.load(fileReader);
			
			databaseDriver = databaseProperties.getProperty("database.driver");
			databaseUrl = databaseProperties.getProperty("database.url");
			databaseUser = databaseProperties.getProperty("database.user");
			databasePassword = databaseProperties.getProperty("database.password");
			
		} catch (FileNotFoundException e) {
			logger.log(Level.SEVERE,"context", e);
			throw new RuntimeException("context",e);
		} catch (IOException e) {
			logger.log(Level.SEVERE,"context", e);
			throw new RuntimeException("context",e);
		}
	}
	
	public static Connection getConnection() {
		try {
			Class.forName(databaseDriver);
			Connection connection = DriverManager.getConnection 
                    (databaseUrl, databaseUser, databasePassword);
			return connection;
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE,"context", e);
			throw new RuntimeException("context",e);
		}  catch (SQLException e) {
			logger.log(Level.SEVERE,"context", e);
			throw new RuntimeException("context",e);
		}
	}
}

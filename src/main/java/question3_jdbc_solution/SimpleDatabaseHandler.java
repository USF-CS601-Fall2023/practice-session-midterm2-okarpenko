package question3_jdbc_solution;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.Set;

/** Modify this class to store searched hotel ids in the database */
public class SimpleDatabaseHandler {
	private static SimpleDatabaseHandler dbHandler = new SimpleDatabaseHandler();

	private SimpleDatabaseHandler() {}

	public static SimpleDatabaseHandler getInstance() {
		return dbHandler;
	}

	private Properties loadConfig(String configPath) throws IOException {
		// Specify which keys must be in properties file
		Set<String> required = new HashSet<>();
		required.add("username");
		required.add("password");
		required.add("database");
		required.add("hostname");

		// Load properties file
		Properties config = new Properties();
		config.load(new FileReader(configPath));

		// Check that required keys are present
		if (!config.keySet().containsAll(required)) {
			String error = "Must provide the following in properties file: ";
			throw new InvalidPropertiesFormatException(error + required);
		}

		return config;
	}

	/** Fill in code in the function that stores the hotel id in the database */
	public void storeHotelIdInDatabase(String id) throws IOException {
		Properties config = loadConfig("database.properties");

		// Create database URI in proper format
		String uri = String.format("jdbc:mysql://%s/%s", config.getProperty("hostname"),
				config.getProperty("database"));
		uri = uri + "?serverTimezone=UTC";
		System.out.println("uri = " + uri);
		System.out.println(config.getProperty("username"));

		// Create database login properties
		Properties login = new Properties();
		login.put("user", config.getProperty("username"));
		login.put("password", config.getProperty("password"));

		PreparedStatement sql; // prepared statement
		try (Connection dbConnection = DriverManager.getConnection(uri, login)) {
			sql = dbConnection.prepareStatement("insert into history (hotelId) VALUES (?);"); // FILL IN sql code in the prepared statement
			sql.setString(1, id);
			sql.executeUpdate();
			// Note: assumes the table "history" already exists
			// Also, before you run this example, you need to update database.properties
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}
}

package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import utils.ConfigReader;

public class DbConnection {

	private DbConnection() {
	}

	private static Connection testdb = null;

	public static synchronized Connection getConnection(DbName dbname) throws IOException, SQLException {
		if (dbname.equals(DbName.TEST_DB)) {
			if (testdb == null) {
				loadConnection(dbname);
			}
			if (testdb.isClosed()) {
				loadConnection(dbname);
			}
		}
		return testdb;
	}

	private static synchronized void loadConnection(DbName dbname) throws SQLException, IOException {
		if (dbname.equals(DbName.TEST_DB)) {
			testdb = DriverManager.getConnection(ConfigReader.getProperty("testdb.url"),
					ConfigReader.getProperty("testdb.username"), ConfigReader.getProperty("testdb.password"));
		}
	}

}

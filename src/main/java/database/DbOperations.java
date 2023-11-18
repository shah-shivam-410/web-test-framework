package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbOperations {
	
	public String[] getValidUserCredential() throws SQLException, IOException {
		String[] user = new String[2];
		Connection conn = DbConnection.getConnection(DbName.TEST_DB);
		ResultSet rs = conn
				.prepareStatement("select user_email, user_password from s_user where user_type = 'VALID'")
				.executeQuery();
		rs.next();
		user[0] = rs.getString("user_email");
		user[1] = rs.getString("user_password");
		conn.close();
		return user;
	}
	
}

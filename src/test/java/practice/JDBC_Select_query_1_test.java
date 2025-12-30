package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBC_Select_query_1_test 
{
	public static void main(String[] args) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/raj", "root", "root");
		Statement state = conn.createStatement();
		ResultSet data = state.executeQuery("select fruit_name from fruits;");
		while(data.next())
		{
			System.out.println(data.getString(1));
		}
	}
}

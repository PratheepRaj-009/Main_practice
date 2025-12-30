package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBC_Select_query_2_test 
{
	public static void main(String[] args) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/raj", "root", "root");
		Statement state = conn.createStatement();
		  ResultSet all_data = state.executeQuery("select * from emp");
	while(all_data.next())
	{
		System.out.println(all_data.getString(1)+"  "+all_data.getString(2)+"  "+all_data.getString(3));
	}
	conn.close();
	
	}
}

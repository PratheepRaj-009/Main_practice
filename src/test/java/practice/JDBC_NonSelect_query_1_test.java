package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBC_NonSelect_query_1_test 
{
	public static void main(String[] args) throws SQLException 
	{
		//step:1-->create driver object
		Driver driver=new Driver();
		//step:2-->Register driver
		DriverManager.registerDriver(driver);
		//step:3-->get connection for database 
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/raj", "root", "root");
		//step:4-->create statement(query)
		Statement state = conn.createStatement();
		String query="show tables;";
		//step:5-->execute query
		
		 ResultSet result = state.executeQuery(query);
		 while(result.next())
		 {
			 System.out.println(result.getString(1));
		 }
		 conn.close();
		
		//step:6-->close the database
	}
}

package genric_utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtilities 
{
	 Connection conn=null;
	ResultSet result=null;
	
	public void connectToDB() throws SQLException
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(PathsConstants.v_url, PathsConstants.username, PathsConstants.password);
		
	}
	public ResultSet executeQuery(String query) throws SQLException
	{
		//create statement
		Statement state=conn.createStatement();
		//execute query
		result = state.executeQuery(query);
		return result;
	}
	public ResultSet updateQuery(String query) throws SQLException
	{

		//create statement
		Statement state=conn.createStatement();
		//execute query
		result = state.executeQuery(query);
		return result;
	}
	public void disconnectDB() throws SQLException
	{
		//disconnect the connection
		conn.close();
	}
	
}

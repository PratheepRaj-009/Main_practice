package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBC_NonSelect_query_2_test 
{
	public static void main(String[] args) throws SQLException 
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection dbs_conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/raj", "root", "root");
		Statement state = dbs_conn.createStatement();
		state.executeQuery("desc emp;");
		state.execute("insert into emp values('Aravind','thuthukudi',4554545);");
		state.execute("insert into emp values('Sathish','selam',684354);");
		//state.execute("create table fruits(fruit_name VARCHAR (20),price_kg INT (25),tast_type VARCHAR (20));");
		state.execute("insert into fruits values('Mango',200,'Sweet and sour');");
		state.execute("insert into fruits values('jack fruit',180,'very Sweet');");
		state.execute("insert into fruits values('banana',35,'Sweet');");
		
	
	dbs_conn.close();
	}
}

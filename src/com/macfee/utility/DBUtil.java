package com.macfee.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
*
* @author Balamurugan
*
*/

public class DBUtil 
{
	private static final String DRIVER_NAME="oracle.jdbc.OracleDriver";
	private static final String URL="jdbc:oracle:thin:@fusqa01-scan:1521/qodbrok";
	private static final String USERNAME="eaibroker";
	private static final String PASSWORD="eaibroker";
	
	public static Connection getConn()
	{
		Connection con=null;
		
		try
		{
			Class.forName(DRIVER_NAME);
			con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConn(Connection con)
	{
		try
		{
			if(con!=null)
				con.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}

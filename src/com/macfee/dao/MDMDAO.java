package com.macfee.dao;

import com.macfee.utility.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
*
* @author Balamurugan
*
*/

public class MDMDAO 
{
	private Connection connection;
    private static Statement statement;
    private static ResultSet rs;
    List<List<String>> lst = new ArrayList<List<String>>();
    List<String> lstOfRows = null;
	private boolean flag;
    public List<List<String>> getEventsFromDataBase() 
    {
        try 
        {
            connection = DBUtil.getConn();
            flag = connection.isValid(10);
            String query = "select event_id,status_id,object_foreignkey from event";
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next())
            {
            	lstOfRows = new ArrayList<String>();
            	Double eventID= rs.getDouble("event_id");
            	Double statusID= rs.getDouble("status_id");
                String objFK=rs.getString("object_foreignkey");
                System.out.println(eventID+"\t"+statusID+"\t"+objFK);
                lstOfRows.add(String.valueOf(eventID));
                lstOfRows.add(String.valueOf(statusID));
                lstOfRows.add(objFK);
                lst.add(lstOfRows);
            }
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return lst;
    }
}

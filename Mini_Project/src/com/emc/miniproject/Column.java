package com.emc.miniproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Yichen LI
 *
 */

public class Column {

	
	public static String[] getCol(String tableName)
	{
		
		Connection conn = null;
		GenericDao dao = null;
		String [] columnName = null;
		
		if(tableName.equals("student"))
		{
			dao = new StudentDao();
			
		}else if(tableName.equals("teacher"))
		{
			dao = new TeacherDao();
		}
		conn = dao.getConnection();
		
		Statement stmt;
		
		try {
			 stmt = conn.createStatement();
			 String myquery = "SELECT * FROM "+tableName;
			 ResultSet rs = stmt.executeQuery(myquery);
			 ResultSetMetaData rsmd = rs.getMetaData();
			 int count = rsmd.getColumnCount();
			 
			 columnName = new String[count];
			 
			 
			 for (int i = 1; i <= count; i++)
			 {
				 columnName[i-1] = rsmd.getColumnLabel(i);
			   
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dao.closeConnection(conn);
		}
		
		
		return columnName;
	}

	

	
	
	
	
	
}

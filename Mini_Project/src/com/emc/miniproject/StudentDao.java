package com.emc.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Yichen LI
 *
 */

public class StudentDao implements GenericDao{

	
		
	    // establish the connection / etablir la connexion
		@Override
		public Connection getConnection()
		{
			
			String connectionUrl = "jdbc:mysql://localhost:3306/mini_project_1";
			String username = "root";
			String password = "admin";
			Connection connection = null;
			
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				connection = DriverManager.getConnection(connectionUrl, username, password);
							
				
			} catch (InstantiationException e) {
			
				e.printStackTrace();
			} catch (IllegalAccessException e) {
			
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			
			return connection;
		}
		
		
		
		// close the connection to the database / fermature de la connexion a la base de donnees
		@Override
		public void closeConnection(Connection connection)
		{
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	
		// return all the fields of student table
		public List<Student> selectAll()
		{
			List<Student> students = new ArrayList<Student>(); // list to store student instance / liste d'objects etudiants
			
			String sql = "SELECT * FROM student";
			
			Connection connection = this.getConnection();
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();
				
				while(results.next())
				{
					int id = results.getInt("student_id");
					String name = results.getString("student_name");
					//String email = results.getString("stu_email");
					String cell = results.getString("student_cell");
					
					Student student = new Student(id, name, cell);
					students.add(student);
				}
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally{
				this.closeConnection(connection);
			}
			
			return students;
			
			
		}



		
		
}

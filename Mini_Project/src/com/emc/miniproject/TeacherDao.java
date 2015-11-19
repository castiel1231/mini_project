package com.emc.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Yichen LI
 *
 */

public class TeacherDao implements GenericDao {

	// establish the connection / establir la connexion
	@Override
	public Connection getConnection() {

		String connectionUrl = "jdbc:mysql://localhost:3306/mini_project_1";
		String username = "root";
		String password = "admin";
		Connection connection = null;

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionUrl, username,
					password);

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

	// close the connection to the database / fermeture de la connexion a la base de donnes
	@Override
	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// return all the fields of teacher table / retourne touts les champs de la table teacher
	public List<Teacher> selectAll() {
		List<Teacher> teachers = new ArrayList<Teacher>(); // list to store teacher instance
															

		String sql = "SELECT * FROM teacher";

		Connection connection = this.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();

			while (results.next()) {
				int id = results.getInt("tea_id");
				String name = results.getString("tea_name");
				int salary = results.getInt("tea_salary");

				Teacher teacher = new Teacher(id, name, salary);
				teachers.add(teacher);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			this.closeConnection(connection);
		}

		return teachers;

	}

}

package com.emc.miniproject;

import java.sql.Connection;

/**
 * 
 * @author Yichen LI
 *
 */

public interface GenericDao {

	public Connection getConnection();
	public void closeConnection(Connection connection);
}

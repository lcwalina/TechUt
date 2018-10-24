package com.exercise.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Table {
	private int id;
	private String name;
	private Date production_date;
	private Double height;
	private Double width;
	private Double thickness;
	boolean are_legs_removable;
	

	private final String URL = "jdbc:hsqldb:hsql://localhost/workdb";
	private String CREATE_TABLE_SQL = "CREATE TABLE Desk(id bigint, name varchar(50), production_date date, height FLOAT(4,2), width FLOAT(4,2), thickness FLOAT(4,2), are_legs_removable bool )";
	private final String DELETE_DESK_SQL = "DELETE FROM Desk;";
	PreparedStatement insertDeskStmt;
	PreparedStatement deleteDeskStmt;
	PreparedStatement deleteAllDesksStmt;
	PreparedStatement createTableDeskStmt;
	
	
	private Statement statement;
	private Connection conn;
	
	public void addDesk(String firstname, String lastname) throws SQLException {
		insertDeskStmt.setString(1, firstname);
		insertDeskStmt.setString(2, lastname);	
		insertDeskStmt.executeUpdate();
		
	}
	
	public void deleteAllPersons() throws SQLException {
		deleteAllDesksStmt.executeUpdate();
	}
	
	public void createTablePerson() throws SQLException{
		createTableDeskStmt.executeUpdate();
	}
	
	public void deleteDeskStmt(int id) throws SQLException{
		deleteDeskStmt.setInt(1, id);
		deleteDeskStmt.executeUpdate();
	}
	
	public Table() throws SQLException{
		conn = DriverManager.getConnection(URL);
		statement = conn.createStatement();
//		ResultSet rs = conn.getMetaData().getTables(null, null, null, null);
//		
//		@SuppressWarnings("unused")
//		boolean tableExists = false;
//		while(rs.next()) {
//			if("Person".equalsIgnoreCase(rs.getString("table_name")));
//			tableExists = true;
//			break;
//			
//		}
//		
		insertDeskStmt = conn.prepareStatement("INSERT INTO Person(id, firstname, lastname) VALUES(1,?,?)");
		deleteAllDesksStmt = conn.prepareStatement(DELETE_DESK_SQL);
		createTableDeskStmt = conn.prepareStatement(CREATE_TABLE_SQL);
		deleteDeskStmt = conn.prepareStatement("DELETE FROM Desk WHERE id=? ");
	}
}

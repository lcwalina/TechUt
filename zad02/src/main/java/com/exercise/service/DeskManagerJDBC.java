package com.exercise.service;
import com.exercise.domain.Desk;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeskManagerJDBC implements  DeskManager{
    private Connection connection;

	private String url = "jdbc:hsqldb:hsql://localhost/workdb";

	private String createTableDesk = "CREATE TABLE Desk(id BIGINT GENERATED BY DEFAULT AS IDENTITY, name VARCHAR(20) UNIQUE, " +
            "production_date DATE, height INTEGER, width INTEGER, thickness INTEGER, are_legs_removable BOOLEAN )";

	private PreparedStatement addDeskStmt;
	private PreparedStatement deleteAllDesksStmt;
	private PreparedStatement deleteDeskStmt;
	private PreparedStatement getAllDesksStmt;
	private PreparedStatement updateDeskStmt;

	private Statement statement;

	public DeskManagerJDBC() {
		try {
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();

			ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("Desk".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}

			if (!tableExists)
				statement.executeUpdate(createTableDesk);

			addDeskStmt = connection.prepareStatement("INSERT INTO Desk (name, production_date, height, width, thickness, are_legs_removable) VALUES (?, ?, ?, ?, ?, ?)");
			deleteAllDesksStmt = connection.prepareStatement("DELETE FROM Desk");
            deleteDeskStmt = connection.prepareStatement("DELETE FROM Desk WHERE id = ?");
			getAllDesksStmt = connection.prepareStatement("SELECT id, name, production_date, height, width, thickness, are_legs_removable FROM Desk");
            updateDeskStmt = connection.prepareStatement("UPDATE Desk SET name = ?, production_date = ?, height = ?, width = ?, thickness = ?, are_legs_removable = ? where id = ?   ");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	Connection getConnection() {
//		return connection;
//	}

    @Override
	public void clearDesks() {
		try {
			deleteAllDesksStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
    public void deleteDesk(int id) {
        try {
            deleteDeskStmt.setInt(1,id);
            deleteDeskStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public int addDesk(Desk desk) {
		int count = 0;
		try {
			addDeskStmt.setString(1,desk.getName());
			addDeskStmt.setDate(2, desk.getProduction_date());
			addDeskStmt.setInt(3, desk.getHeight());
			addDeskStmt.setInt(4, desk.getWidth());
			addDeskStmt.setInt(5, desk.getThickness());
			addDeskStmt.setBoolean(6, desk.isAre_legs_removable());

			count = addDeskStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Desk> getAllDesks() {
		List<Desk> desks = new ArrayList<Desk>();

		try {
			ResultSet rs = getAllDesksStmt.executeQuery();
			while (rs.next()) {
				Desk d = new Desk();
				d.setId(rs.getInt("id"));
				d.setName(rs.getString("name"));
				d.setProduction_date(rs.getDate("date"));
				d.setHeight(rs.getInt("height"));
				d.setWidth(rs.getInt("width"));
				d.setThickness(rs.getInt("thickness"));
				d.setAre_legs_removable(rs.getBoolean("are_legs_removable"));

				desks.add(d);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return desks;
	}

    @Override
    public void updateDesk(int id, String name, Date production_date, int height,  int width,  int thickness,  boolean are_legs_removable){
        try {
            updateDeskStmt.setString(1, name);
            updateDeskStmt.setDate(2, production_date);
            updateDeskStmt.setInt(3, height);
            updateDeskStmt.setInt(4, width);
            updateDeskStmt.setInt(5, thickness);
            updateDeskStmt.setBoolean(6, are_legs_removable);
            updateDeskStmt.setInt(7, id);

            updateDeskStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            //!!!! ALARM
        }

    }
}

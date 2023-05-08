package org.mql.biblio.dao.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Database {
	
	private DataSource dataSource;

	private Connection db;
	
	public Database() {
	}

	public Database(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		db = dataSource.getConnection();
	}

	public String[][] executeQuery(String query) {
		try {
			Statement sql = db.createStatement();
			ResultSet rs = sql.executeQuery(query);
			rs.last();
			int rows = rs.getRow();
			ResultSetMetaData rsm = rs.getMetaData();
			int cols = rsm.getColumnCount();
			String data[][] = new String[rows + 1][cols];
			for (int i = 0; i < cols; i++) {
				data[0][i] = rsm.getColumnName(i + 1);
			}

			rs.beforeFirst();
			// index commence à 1
			int row = 0;
			while (rs.next()) {
				row++;
				for (int i = 0; i < cols; i++) {
					data[row][i] = rs.getString(i + 1);
				}

				System.out.println(rs.getString(2)); // "Author";
			}
			rs.close();
			return data;

		} catch (Exception ex) {
			System.out.println("Erreur: " + ex.getMessage());
			return null;
		}
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	// une autre fonction de recherche
	public String[][] select(String tableName) {
		return executeQuery("SELECT * FROM " + tableName);
	}

	public String[][] select(String tableName, String columnName, String keyWord) {
		return executeQuery("SELECT * FROM " + tableName + " WHERE " + columnName + " LIKE '%" + keyWord + "%'");

	}

}

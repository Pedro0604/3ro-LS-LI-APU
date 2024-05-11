package ar.edu.unlp.info.oo2.ejercicio14;

import java.util.Collection;
import java.util.List;

public class DatabaseAccessProxy implements DatabaseAccess {
	private DatabaseAccess realDatabaseAccess;
	private int userId;

	public DatabaseAccessProxy(DatabaseAccess realDatabaseAccess, Integer userId) {
		this.realDatabaseAccess = realDatabaseAccess;
		this.userId = userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	private boolean isAuthenticated() {
		return this.userId == 1;
	}

	@Override
	public int insertNewRow(List<String> rowData) {
		if (this.isAuthenticated()) {
			return this.realDatabaseAccess.insertNewRow(rowData);
		}
		return -1;
	}

	@Override
	public Collection<String> getSearchResults(String queryString) {
		if (this.isAuthenticated()) {
			return this.realDatabaseAccess.getSearchResults(queryString);
		}
		return null;
	}
}

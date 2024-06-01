package ar.edu.unlp.info.oo2.ejercicio1;

import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
			Logger.getLogger("database").log(Level.WARNING, "Acceso válido para inserciones a la base de datos");
			return this.realDatabaseAccess.insertNewRow(rowData);
		}
		Logger.getLogger("database").log(Level.SEVERE, "Acceso inválido a la base de datos");
		return -1;
	}

	@Override
	public Collection<String> getSearchResults(String queryString) {
		if (this.isAuthenticated()) {
			Logger.getLogger("database").log(Level.INFO, "Acceso válido para búsquedas a la base de datos");
			return this.realDatabaseAccess.getSearchResults(queryString);
		}
		Logger.getLogger("database").log(Level.SEVERE, "Acceso inválido a la base de datos");
		return null;
	}
}

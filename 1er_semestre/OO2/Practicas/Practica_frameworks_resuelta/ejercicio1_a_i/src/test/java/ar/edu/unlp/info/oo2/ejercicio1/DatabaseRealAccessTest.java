package ar.edu.unlp.info.oo2.ejercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo2.ejercicio1_b.i.JSONFormatter;
import ar.edu.unlp.info.oo2.ejercicio1_b.i.UpperCaseSimpleFormater;
import ar.edu.unlp.info.oo2.ejercicio1_b_ii.FilterHandler;

public class DatabaseRealAccessTest {
	private DatabaseAccess authorizedDatabase, unauthorizedDatabase;

	@BeforeAll
	public static void setUpLoggers() {
		// Añade UpperCaseSimpleFormatter del ejercicio 1_b_i
		Handler consoleUpperCaseHandler = new ConsoleHandler();
		consoleUpperCaseHandler.setFormatter(new UpperCaseSimpleFormater());
		Logger.getLogger("database").addHandler(consoleUpperCaseHandler);

		// Añade JSONFormatter del ejercicio 1_b_i
		Handler consoleJSONHandler = new ConsoleHandler();
		consoleJSONHandler.setFormatter(new JSONFormatter());
		Logger.getLogger("database").addHandler(consoleJSONHandler);

		// Añade FilterHandler del ejercicio 1_b_ii
		FilterHandler filterHandler = new FilterHandler();
		filterHandler.addFilteredWord("base");
		filterHandler.addFilteredWord("búsquedas");
		Logger.getLogger("database").addHandler(filterHandler);
	}

	@BeforeEach
	void setUp() throws Exception {
		this.authorizedDatabase = new DatabaseAccessProxy(new DatabaseRealAccess(), 1);
		this.unauthorizedDatabase = new DatabaseAccessProxy(new DatabaseRealAccess(), 2);
	}

	@Test
	void testGetSearchResults() {
		assertEquals(Arrays.asList("Spiderman", "Marvel"),
				this.authorizedDatabase.getSearchResults("select * from comics where id=1"));

		assertEquals(Collections.emptyList(),
				this.authorizedDatabase.getSearchResults("select * from comics where id=10"));

		assertNull(this.unauthorizedDatabase.getSearchResults("select * from comics where id=1"));
		assertNull(this.unauthorizedDatabase.getSearchResults("select * from comics where id=10"));
	}

	@Test
	void testInsertNewRow() {
		assertEquals(3, this.authorizedDatabase.insertNewRow(Arrays.asList("Patoruzú", "La flor")));
		assertEquals(Arrays.asList("Patoruzú", "La flor"),
				this.authorizedDatabase.getSearchResults("select * from comics where id=3"));

		assertEquals(-1, this.unauthorizedDatabase.insertNewRow(Arrays.asList("Patoruzú", "La flor")));
		assertNull(this.unauthorizedDatabase.getSearchResults("select * from comics where id=3"));
	}
}
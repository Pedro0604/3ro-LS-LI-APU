package ar.edu.unlp.info.oo2.ejercicio14;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseRealAccessTest {
	private DatabaseAccess authorizedDatabase, unauthorizedDatabase;

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
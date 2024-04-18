package ar.edu.unlp.info.oo2.ejercicio8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ToDoItemTest {
	private ToDoItem t;

	@BeforeEach
	void setUp() throws Exception {
		t = new ToDoItem("item");
	}

	@Test
	public void testPending() {
		assertEquals("pending", t.getStateName());

		try {
			t.togglePause();
		} catch (Exception e) {
			assertEquals("pending", t.getStateName());
			assertEquals("El objeto ToDoItem no se encuentra en pause o in-progress", e.getMessage());
		}

		t.finish();
		assertEquals("pending", t.getStateName());

		try {
			t.workedTime();
		} catch (Exception e) {
			assertEquals("pending", t.getStateName());
			assertEquals("El objeto ToDoItem no ha sido iniciado", e.getMessage());
		}

		t.addComment("hola");
		assertTrue(t.getComments().contains("hola"));

		t.start();
		assertEquals("in-progress", t.getStateName());
	}

	@Test
	public void testInProgress() {
		t.start();
		t.start();
		assertEquals("in-progress", t.getStateName());

		t.togglePause();
		assertEquals("paused", t.getStateName());
		t.togglePause();

		assertNotNull(t.workedTime());
		assertTrue(Duration.between(t.getStartTime(), LocalDateTime.now()).equals(t.workedTime()));

		t.addComment("hola");
		assertTrue(t.getComments().contains("hola"));

		t.finish();
		assertEquals("finished", t.getStateName());
	}

	@Test
	public void testPaused() {
		t.start();
		t.togglePause();
		t.start();
		assertEquals("paused", t.getStateName());

		t.togglePause();
		assertEquals("in-progress", t.getStateName());
		t.togglePause();

		assertNotNull(t.workedTime());
		assertTrue(Duration.between(t.getStartTime(), LocalDateTime.now()).equals(t.workedTime()));

		t.addComment("hola");
		assertTrue(t.getComments().contains("hola"));

		t.finish();
		assertEquals("finished", t.getStateName());
	}

	@Test
	public void testFinished() {
		t.start();
		t.finish();
		t.start();
		assertEquals("finished", t.getStateName());

		try {
			t.togglePause();
		} catch (Exception e) {
			assertEquals("finished", t.getStateName());
			assertEquals("El objeto ToDoItem no se encuentra en pause o in-progress", e.getMessage());
		}

		t.finish();
		assertEquals("finished", t.getStateName());

		assertNotNull(t.workedTime());
		assertTrue(Duration.between(t.getStartTime(), t.getEndTime()).equals(t.workedTime()));

		t.addComment("hola");
		assertEquals(0, t.getComments().size());
	}
}

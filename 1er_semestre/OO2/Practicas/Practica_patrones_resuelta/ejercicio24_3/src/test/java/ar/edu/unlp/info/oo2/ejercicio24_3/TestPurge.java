package ar.edu.unlp.info.oo2.ejercicio24_3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPurge {
	private Purge purge;
	private MixingTank emptyFakeTank, fullFakeTank, saboteurTank;

	@BeforeEach
	void setUp() throws Exception {
		purge = new Purge();
		emptyFakeTank = new MixingTankFakeObject(0);
		fullFakeTank = new MixingTankFakeObject(100);
		saboteurTank = new MixingTankSaboteurFakeObject();
	}

	@Test
	void testExecute() {
		this.purge.execute(emptyFakeTank);
		assertTrue(this.purge.isDone());
		assertFalse(this.purge.isSuccessful());

		this.purge.execute(fullFakeTank);
		assertTrue(this.purge.isDone());
		assertTrue(this.purge.isSuccessful());

		this.purge.execute(saboteurTank);
		assertTrue(this.purge.isDone());
		assertFalse(this.purge.isSuccessful());
	}
}

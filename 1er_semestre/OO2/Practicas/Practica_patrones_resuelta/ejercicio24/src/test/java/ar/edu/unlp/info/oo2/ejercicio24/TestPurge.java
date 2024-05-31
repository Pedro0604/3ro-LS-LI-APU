package ar.edu.unlp.info.oo2.ejercicio24;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPurge {
	private Purge purge;
	private MixingTank stubTank, saboteurTank;

	@BeforeEach
	void setUp() throws Exception {
		purge = new Purge();
		stubTank = new MixingTankTestStub();
		saboteurTank = new MixingTankSaboteurTestStub();
	}

	@Test
	void testExecute() {
		this.purge.execute(stubTank);
		assertTrue(this.purge.isDone());
		assertTrue(this.purge.isSuccessful());

		this.purge.execute(saboteurTank);
		assertTrue(this.purge.isDone());
		assertFalse(this.purge.isSuccessful());
	}
}

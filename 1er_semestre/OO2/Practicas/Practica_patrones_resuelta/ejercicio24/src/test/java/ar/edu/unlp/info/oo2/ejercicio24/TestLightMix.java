package ar.edu.unlp.info.oo2.ejercicio24;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLightMix {
	private LightMix lm;
	private MixingTank stubTank, saboteurTank;

	@BeforeEach
	void setUp() throws Exception {
		lm = new LightMix();
		stubTank = new MixingTankTestStub();
		saboteurTank = new MixingTankSaboteurTestStub();
	}

	@Test
	void testExecute() {
		this.lm.execute(stubTank);
		assertTrue(this.lm.isDone());
		assertTrue(this.lm.isSuccessful());

		this.lm.execute(saboteurTank);
		assertTrue(this.lm.isDone());
		assertFalse(this.lm.isSuccessful());
	}
}

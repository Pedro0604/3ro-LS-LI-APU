package ar.edu.unlp.info.oo2.ejercicio24_3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLightMix {
	private LightMix lm;
	private MixingTank fakeTank, saboteurTank;

	@BeforeEach
	void setUp() throws Exception {
		lm = new LightMix();
		fakeTank = new MixingTankFakeObject(0);
		saboteurTank = new MixingTankSaboteurFakeObject();
	}

	@Test
	void testExecute() {
		this.lm.execute(fakeTank);
		assertTrue(this.lm.isDone());
		assertTrue(this.lm.isSuccessful());
		assertEquals(5, this.fakeTank.getMixerPower());

		this.lm.execute(saboteurTank);
		assertTrue(this.lm.isDone());
		assertFalse(this.lm.isSuccessful());
	}
}

package ar.edu.unlp.info.oo2.ejercicio24;

public class MixingTankTestStub extends MixingTank {
	@Override
	public boolean heatPower(int percentage) {
		return true;
	}

	@Override
	public boolean mixerPower(int percentage) {
		return true;
	}

	@Override
	public boolean purge() {
		return true;
	}

	@Override
	public double upTo() {
		return 0;
	}

	@Override
	public double temperature() {
		return 0;
	}
}

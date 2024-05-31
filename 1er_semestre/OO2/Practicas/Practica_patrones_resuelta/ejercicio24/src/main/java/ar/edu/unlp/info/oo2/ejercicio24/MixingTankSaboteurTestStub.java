package ar.edu.unlp.info.oo2.ejercicio24;

public class MixingTankSaboteurTestStub extends MixingTank {
	@Override
	public boolean heatPower(int percentage) throws Exception {
		throw new Exception("Error en el heat power");
	}

	@Override
	public boolean mixerPower(int percentage) throws Exception {
		throw new Exception("Error en el mixer");
	}

	@Override
	public boolean purge() throws Exception {
		throw new Exception("Error en la purga");
	}

	@Override
	public double upTo() throws Exception {
		throw new Exception("Error en la medida del volumen ocupado");
	}

	@Override
	public double temperature() throws Exception {
		throw new Exception("Error en la medida de la temperatura");
	}
}

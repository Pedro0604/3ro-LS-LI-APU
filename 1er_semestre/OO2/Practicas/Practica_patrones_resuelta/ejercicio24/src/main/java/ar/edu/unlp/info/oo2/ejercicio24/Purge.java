package ar.edu.unlp.info.oo2.ejercicio24;

public class Purge extends ProcessStep {
	@Override
	protected boolean basicExecute(MixingTank tank) {
		try {
			return tank.heatPower(0) && tank.mixerPower(0) && tank.purge();
		} catch (Exception e) {
			return false;
		}
	}
}
package ar.edu.unlp.info.oo2.ejercicio24;

public class LightMix extends ProcessStep {
	@Override
	protected boolean basicExecute(MixingTank tank) {
		try {
			return tank.heatPower(20) && tank.mixerPower(5);
		} catch (Exception e) {
			return false;
		}
	}
}
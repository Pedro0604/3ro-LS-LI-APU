package ar.edu.unlp.info.oo2.ejercicio24_3;

public class LightMix extends ProcessStep {
	@Override
	protected boolean basicExecute(MixingTank tank) {
		try {
			double temp = tank.temperature();
			tank.heatPower(100);
			Thread.sleep(2000);
			if (tank.temperature() - temp == 10) {
				tank.mixerPower(5);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
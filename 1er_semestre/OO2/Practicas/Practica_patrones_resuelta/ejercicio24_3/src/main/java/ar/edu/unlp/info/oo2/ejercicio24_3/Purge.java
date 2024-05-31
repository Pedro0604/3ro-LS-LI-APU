package ar.edu.unlp.info.oo2.ejercicio24_3;

public class Purge extends ProcessStep {
	@Override
	protected boolean basicExecute(MixingTank tank) {
		try {
			if (tank.upTo() == 0) {
				return false;
			} else {
				tank.heatPower(0);
				tank.mixerPower(0);
				tank.purge();
				Thread.sleep(4000);
				if (tank.upTo() != 0) {
					return false;
				}
				return true;
			}

		} catch (Exception e) {
			return false;
		}
	}
}
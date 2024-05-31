package ar.edu.unlp.info.oo2.ejercicio24_3;

public class MixingTankFakeObject extends MixingTank {
	private int heatPower, mixerPower;
	private double upTo;
	private double temperature;

	public MixingTankFakeObject(double upTo) {
		this.upTo = upTo;
		this.heatPower = 0;
		this.mixerPower = 0;
		this.temperature = 20;
	}

	@Override
	public boolean heatPower(int percentage) throws InterruptedException {
		this.heatPower = percentage;
		this.temperature += this.getTemperatureIncreasePerSecond();
		this.temperature += this.getTemperatureIncreasePerSecond();
		Thread.sleep(2000);
		return true;
	}

	@Override
	public boolean mixerPower(int percentage) {
		this.mixerPower = percentage;
		return true;
	}

	@Override
	public boolean purge() throws InterruptedException {
		this.upTo = 0;
		Thread.sleep(4000);
		return true;
	}

	@Override
	public double upTo() {
		return this.upTo;
	}

	private double getTemperatureIncreasePerSecond() {
		if (this.heatPower == 100) {
			return 5.0;
		} else if (this.heatPower > 75) {
			return 4.0;
		} else if (this.heatPower >= 50) {
			return 2.0;
		} else if (this.heatPower >= 25) {
			return 1.0;
		} else if (this.heatPower >= 0) {
			return 0;
		} else {
			throw new IllegalArgumentException("Invalid percentage: " + this.heatPower);
		}
	}

	@Override
	public double temperature() {
		return this.temperature;
	}

	public int getMixerPower() {
		return this.mixerPower;
	}
}

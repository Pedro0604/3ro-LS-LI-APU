package ar.edu.unlp.info.oo2.ejercicio24_3;

public abstract class MixingTank {

	public abstract boolean heatPower(int percentage) throws Exception;

	public abstract boolean mixerPower(int percentage) throws Exception;

	public abstract boolean purge() throws Exception;

	public abstract double upTo() throws Exception;

	public abstract double temperature() throws Exception;

	public int getMixerPower() {
		return -1;
	}
}
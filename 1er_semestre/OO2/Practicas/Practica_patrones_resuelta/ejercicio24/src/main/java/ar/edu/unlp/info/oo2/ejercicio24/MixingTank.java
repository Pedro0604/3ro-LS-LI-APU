package ar.edu.unlp.info.oo2.ejercicio24;

public abstract class MixingTank {

	public abstract boolean heatPower(int percentage) throws Exception;

	public abstract boolean mixerPower(int percentage) throws Exception;

	public abstract boolean purge() throws Exception;

	public abstract double upTo() throws Exception;

	public abstract double temperature() throws Exception;
}
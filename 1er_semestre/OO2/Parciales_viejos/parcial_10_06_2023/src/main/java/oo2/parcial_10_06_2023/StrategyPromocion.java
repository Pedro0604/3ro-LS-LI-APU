package oo2.parcial_10_06_2023;

public abstract class StrategyPromocion {
	protected Persona persona;

	public StrategyPromocion(Persona persona) {
		this.persona = persona;
	}

	public abstract double getMontoDescuento();
}

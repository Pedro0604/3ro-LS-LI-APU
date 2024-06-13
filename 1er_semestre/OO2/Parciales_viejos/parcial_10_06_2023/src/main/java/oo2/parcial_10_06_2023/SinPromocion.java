package oo2.parcial_10_06_2023;

public class SinPromocion extends StrategyPromocion {

	public SinPromocion(Persona persona) {
		super(persona);
	}

	@Override
	public double getMontoDescuento() {
		return 0;
	}

}

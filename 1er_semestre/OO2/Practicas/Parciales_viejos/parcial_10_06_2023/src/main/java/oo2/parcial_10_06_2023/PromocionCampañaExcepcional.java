package oo2.parcial_10_06_2023;

public class PromocionCampañaExcepcional extends StrategyPromocion {

	public PromocionCampañaExcepcional(Persona persona) {
		super(persona);
	}

	@Override
	public double getMontoDescuento() {
		return this.persona.getCostoSeguroMasEconomico() * 0.5;
	}

}

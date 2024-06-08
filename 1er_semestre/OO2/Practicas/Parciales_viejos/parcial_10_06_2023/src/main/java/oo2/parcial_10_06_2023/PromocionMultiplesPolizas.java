package oo2.parcial_10_06_2023;

public class PromocionMultiplesPolizas extends StrategyPromocion {

	public PromocionMultiplesPolizas(Persona persona) {
		super(persona);
	}

	@Override
	public double getMontoDescuento() {
		if (this.persona.getCantPolizas() >= 2) {
			return this.persona.getSumaSeguros() * 0.1;
		}
		return 0.0;
	}

}

package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class PersonaJuridica extends Cliente {
	private String cuit;
	private static double descuentoParaPersonaJuridica = 0.15;

	public PersonaJuridica(String nombre, String numeroTelefono, String cuit) {
		super(nombre, numeroTelefono);
		this.cuit = cuit;
	}

	@Override
	public double getMontoDescuento(double monto) {
		return monto * PersonaJuridica.descuentoParaPersonaJuridica;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
}

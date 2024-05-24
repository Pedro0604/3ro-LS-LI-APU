package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class PersonaFisica extends Cliente {
	private String dni;
	private static double descuentoFis = 0;

	public PersonaFisica(String nombre, String numeroTelefono, String dni) {
		super(nombre, numeroTelefono);
		this.dni = dni;
	}

	@Override
	public double getMontoDescuento(double monto) {
		return monto * PersonaFisica.descuentoFis;
	}
}

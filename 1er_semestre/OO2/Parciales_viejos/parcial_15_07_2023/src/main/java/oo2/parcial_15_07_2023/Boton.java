package oo2.parcial_15_07_2023;

public class Boton extends ElementoAtomico {
	private String accion;

	public Boton(String texto, String accion) {
		super(texto);
		this.accion = accion;
	}

	@Override
	public void aplicarEstilo(ConfiguracionEstilo estilo) {
		this.estilo = estilo.getEstiloBoton();
	}

	@Override
	public String imprimir() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<boton estilo=\"");
		buffer.append(this.estilo);
		buffer.append("\" texto=\"");
		buffer.append(this.texto);
		buffer.append("\" accion=\"");
		buffer.append(this.accion);
		buffer.append("\"/>");
		return buffer.toString();
	}
}

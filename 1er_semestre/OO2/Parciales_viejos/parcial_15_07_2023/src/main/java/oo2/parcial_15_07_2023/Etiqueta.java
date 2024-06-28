package oo2.parcial_15_07_2023;

public class Etiqueta extends ElementoAtomico {

	public Etiqueta(String texto) {
		super(texto);
	}

	@Override
	public void aplicarEstilo(ConfiguracionEstilo estilo) {
		this.estilo = estilo.getEstiloEtiqueta();
	}

	@Override
	public String imprimir() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<etiqueta estilo=\"");
		buffer.append(this.estilo);
		buffer.append("\"/> ");
		buffer.append(this.texto);
		buffer.append(" </etiqueta>");
		return buffer.toString();
	}
}

package oo2.parcial_15_07_2023;

import java.util.ArrayList;
import java.util.List;

public class Contenedor extends Elemento {
	private List<Elemento> elementos;

	public Contenedor() {
		this.elementos = new ArrayList<>();
	}

	public void addElemento(Elemento e) {
		this.elementos.add(e);
	}

	@Override
	public void aplicarEstilo(ConfiguracionEstilo estilo) {
		this.elementos.forEach(elemento -> elemento.aplicarEstilo(estilo));
	}

	@Override
	public String imprimir() {
		StringBuffer buffer = new StringBuffer("<contenedor>\n");
		this.elementos.forEach(elemento -> buffer.append(elemento.imprimir() + "\n"));
		buffer.append("</contenedor>");
		return buffer.toString();
	}
}

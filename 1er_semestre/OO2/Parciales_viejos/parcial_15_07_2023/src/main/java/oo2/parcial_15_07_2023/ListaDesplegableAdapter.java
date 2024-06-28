package oo2.parcial_15_07_2023;

public class ListaDesplegableAdapter extends Elemento {
	private ListaDesplegable adaptee;

	public ListaDesplegableAdapter(ListaDesplegable lista) {
		this.adaptee = lista;
	}

	@Override
	public void aplicarEstilo(ConfiguracionEstilo estilo) {
		this.adaptee.setStyle(estilo.getEstiloEtiqueta());
	}

	@Override
	public String imprimir() {
		return this.adaptee.print();
	}

}

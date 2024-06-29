package oo2.mi_parcial_29_06_2024;

public class Catalogo {
	public Componente getComponente(String nombre) {
		return new Componente(10, 1000, nombre);
	}
}

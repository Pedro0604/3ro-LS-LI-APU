package ar.edu.unlp.info.oo2.ejercicio7;

import java.util.List;

public class FileSystem {
	private Directorio root;

	public FileSystem(Directorio root) {
		this.root = root;
	}

	public int tamanoTotalOcupado() {
		return this.root.getTamano();
	}

	public Archivo archivoMasGrande() {
		return this.root.archivoMasGrande();
	}

	public Archivo archivoMasNuevo() {
		return this.root.archivoMasNuevo();
	}

	public Elemento buscar(String nombre) {
		return this.root.buscar(nombre);
	}

	public List<Elemento> buscarTodos(String nombre) {
		return this.root.buscarTodos(nombre);
	}

	public String listadoDeContenido() {
		return this.root.listadoDeContenido("");
	}
}

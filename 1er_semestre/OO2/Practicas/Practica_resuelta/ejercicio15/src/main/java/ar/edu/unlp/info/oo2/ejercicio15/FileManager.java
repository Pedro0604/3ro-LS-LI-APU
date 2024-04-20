package ar.edu.unlp.info.oo2.ejercicio15;

import java.util.ArrayList;
import java.util.List;

public class FileManager {
	private List<File> archivos;

	public FileManager() {
		this.archivos = new ArrayList<>();
	}

	public List<File> getArchivos() {
		return archivos;
	}

	public void addArchivo(File archivo) {
		this.archivos.add(archivo);
	}
}

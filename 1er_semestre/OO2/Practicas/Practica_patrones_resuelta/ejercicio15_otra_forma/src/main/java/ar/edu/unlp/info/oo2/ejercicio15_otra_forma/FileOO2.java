package ar.edu.unlp.info.oo2.ejercicio15_otra_forma;

import java.time.LocalDate;

public class FileOO2 extends AbstractFile {
	private String nombre, extension, permisos;
	private int tamanio;
	private LocalDate fechaCreacion, fechaModificacion;

	public FileOO2(String nombre, String extension, String permisos, int tamanio) {
		this.nombre = nombre;
		this.extension = extension;
		this.permisos = permisos;
		this.tamanio = tamanio;
		this.fechaCreacion = LocalDate.now();
		// Muchachos
		this.fechaModificacion = LocalDate.of(2022, 12, 18);
	}

	@Override
	public String prettyPrint() {
		return "";
	}

	public String getNombre() {
		return nombre;
	}

	public String getExtension() {
		return extension;
	}

	public String getPermisos() {
		return permisos;
	}

	public int getTamanio() {
		return tamanio;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public LocalDate getFechaModificacion() {
		return fechaModificacion;
	}

	@Override
	public AbstractFile removeFilter() {
		return this;
	}
}

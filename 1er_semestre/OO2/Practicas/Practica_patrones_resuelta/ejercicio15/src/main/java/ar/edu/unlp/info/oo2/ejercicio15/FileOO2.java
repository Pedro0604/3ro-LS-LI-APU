package ar.edu.unlp.info.oo2.ejercicio15;

import java.time.LocalDateTime;

public class FileOO2 implements File {
	private String nombre, extension, permisos;
	private int tamanio;
	private LocalDateTime fechaCreacion, fechaModificacion;

	public FileOO2(String nombre, String extension, int tamanio, String permisos) {
		this.nombre = nombre;
		this.extension = extension;
		this.permisos = permisos;
		this.tamanio = tamanio;
		this.fechaCreacion = LocalDateTime.now();
		this.fechaModificacion = LocalDateTime.now();
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

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}

	@Override
	public String prettyPrint() {
		return "";
	}
}

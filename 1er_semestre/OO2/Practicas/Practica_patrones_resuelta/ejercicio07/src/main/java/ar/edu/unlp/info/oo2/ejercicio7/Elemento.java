package ar.edu.unlp.info.oo2.ejercicio7;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Elemento {
	private String nombre;
	private LocalDateTime fechaCreacion;

	public Elemento(String nombre) {
		this.nombre = nombre;
		this.fechaCreacion = LocalDateTime.now();
		try {
			// Agregado porque sino los archivos creados en el test se crean exactamente al
			// mismo tiempo y no hay un archivo mas nuevo que los otros para devolver
			Thread.sleep(1);
		} catch (Exception e) {
			System.out.println("error: " + e);
		}
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public abstract int getTamano();

	public List<Elemento> getChildren() {
		return null;
	}

	public boolean hasNameEqualsTo(String name) {
		return this.nombre.equals(name);
	}

	public Archivo archivoMasGrande() {
		return null;
	}

	public Archivo archivoMasNuevo() {
		return null;
	}

	public Elemento buscar(String nombre) {
		return null;
	}

	public List<Elemento> buscarTodos(String nombre) {
		return null;
	}

	public String listadoDeContenido(String nombre) {
		return null;
	}
}

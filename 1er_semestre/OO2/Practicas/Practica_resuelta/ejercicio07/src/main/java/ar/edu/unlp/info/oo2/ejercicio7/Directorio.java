package ar.edu.unlp.info.oo2.ejercicio7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Directorio extends Elemento {
	private List<Elemento> children;

	public Directorio(String nombre) {
		super(nombre);
		this.children = new ArrayList<>();
	}

	public int getTamano() {
		return 32 * 1024 + this.children.stream().mapToInt(c -> c.getTamano()).sum();
	}

	@Override
	public List<Elemento> getChildren() {
		return this.children;
	}

	public void addChild(Elemento child) {
		this.children.add(child);
	}

	public void removeAllChildren() {
		this.children.clear();
	}

	// Archivo mas grande
	private Archivo archivoMasGrandeFromChild(Elemento c) {
		if (c.getChildren() != null) {
			return c.archivoMasGrande();
		}
		return (Archivo) c;
	}

	public Archivo archivoMasGrande() {
		return this.children.stream().map(c -> archivoMasGrandeFromChild(c)).filter(arch -> arch != null)
				.max((arch1, arch2) -> Integer.compare(arch1.getTamano(), arch2.getTamano())).orElse(null);
	}

	// Archivo mas nuevo
	private Archivo archivoMasNuevoFromChild(Elemento c) {
		if (c.getChildren() != null) {
			return c.archivoMasNuevo();
		}
		return (Archivo) c;
	}

	public Archivo archivoMasNuevo() {
		return this.children.stream().map(c -> archivoMasNuevoFromChild(c)).filter(arch -> arch != null)
				.max((arch1, arch2) -> arch1.getFechaCreacion().compareTo(arch2.getFechaCreacion())).orElse(null);
	}

	// Buscar
	private Elemento buscarEnChild(Elemento c, String nombre) {
		if (c.getChildren() != null) {
			return c.buscar(nombre);
		}
		return c;
	}

	public Elemento buscar(String nombre) {
		return this.getNombre().equals(nombre) ? this
				: this.children.stream().map(c -> buscarEnChild(c, nombre))
						.filter(el -> el != null && el.getNombre().equals(nombre)).findFirst().orElse(null);
	}

	// Buscar todos
	private List<Elemento> buscarTodosEnChild(Elemento c, String nombre) {
		if (c.getChildren() != null) {
			return c.buscarTodos(nombre);
		}
		List<Elemento> list = new ArrayList<>();
		list.add(c);
		return list;
	}

	public List<Elemento> buscarTodos(String nombre) {
		List<Elemento> list = this.children.stream().map(c -> buscarTodosEnChild(c, nombre)).flatMap(List::stream)
				.filter(el -> el.getNombre().equals(nombre)).collect(Collectors.toList());
		if (this.getNombre().equals(nombre))
			list.add(this);
		return list;
	}

	public String listadoDeContenidoEnChild(Elemento c, String path) {
		if (c.getChildren() != null) {
			return c.listadoDeContenido(path);
		}
		return path + c.getNombre();
	}

	public String listadoDeContenido(String previousPath) {
		String contenido = previousPath + this.getNombre() + "/" + "\n";

		if (!this.children.isEmpty()) {
			contenido += this.children.stream()
					.map(c -> listadoDeContenidoEnChild(c, previousPath + this.getNombre() + "/"))
					.collect(Collectors.joining("\n"));
		}

		if (contenido.endsWith("\n")) {
			contenido = contenido.substring(0, contenido.length() - 1);
		}
		return contenido;
	}
}

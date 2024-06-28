package ar.edu.unlp.info.oo2.ejercicio15_otra_forma;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileManagerTest {
	private FileManager fm;

	@BeforeEach
	void setUp() throws Exception {
		this.fm = new FileManager(new FileOO2("Messi", ".campeondelmundo", "r", 2022));
	}

	@Test
	public void testImpresion() {
		AbstractFile archivo = this.fm.añadirNombre();
		System.out.println(archivo.prettyPrint());
		this.fm.removeLastFilter();

		archivo = this.fm.añadirExtension();
		System.out.println(archivo.prettyPrint());
		this.fm.removeLastFilter();

		archivo = this.fm.añadirTamanio();
		System.out.println(archivo.prettyPrint());
		this.fm.removeLastFilter();

		archivo = this.fm.añadirFechaCreacion();
		System.out.println(archivo.prettyPrint());
		this.fm.removeLastFilter();

		archivo = this.fm.añadirFechaModificacion();
		System.out.println(archivo.prettyPrint());
		this.fm.removeLastFilter();

		archivo = this.fm.añadirPermisos();
		System.out.println(archivo.prettyPrint());
		this.fm.removeLastFilter();

		this.fm.añadirNombre();
		archivo = this.fm.añadirExtension();
		System.out.println(archivo.prettyPrint());
		archivo = this.fm.añadirTamanio();
		System.out.println(archivo.prettyPrint());
		archivo = this.fm.añadirFechaCreacion();
		System.out.println(archivo.prettyPrint());
		archivo = this.fm.añadirFechaModificacion();
		System.out.println(archivo.prettyPrint());
		archivo = this.fm.añadirPermisos();
		System.out.println(archivo.prettyPrint());

		this.fm.resetFilters();

		// Ejemplos del cuadernillo
		this.fm.añadirNombre();
		this.fm.añadirExtension();
		archivo = this.fm.añadirFechaCreacion();
		System.out.println(archivo.prettyPrint());

		this.fm.resetFilters();

		this.fm.añadirPermisos();
		this.fm.añadirNombre();
		this.fm.añadirExtension();
		archivo = this.fm.añadirTamanio();
		System.out.println(archivo.prettyPrint());
	}
}

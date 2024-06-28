package ar.edu.unlp.info.oo2.ejercicio15_otra_forma;

import ar.edu.unlp.info.oo2.ejercicio15_otra_forma.decorators.ExtensionDecorator;
import ar.edu.unlp.info.oo2.ejercicio15_otra_forma.decorators.FechaCreacionDecorator;
import ar.edu.unlp.info.oo2.ejercicio15_otra_forma.decorators.FechaModificacionDecorator;
import ar.edu.unlp.info.oo2.ejercicio15_otra_forma.decorators.NombreDecorator;
import ar.edu.unlp.info.oo2.ejercicio15_otra_forma.decorators.PermisosDecorator;
import ar.edu.unlp.info.oo2.ejercicio15_otra_forma.decorators.TamanioDecorator;

public class FileManager {
	private AbstractFile file, originalFile;

	public FileManager(AbstractFile file) {
		this.file = file;
		this.originalFile = file;
	}

	public AbstractFile resetFilters() {
		return this.file = this.originalFile;
	}

	public AbstractFile removeLastFilter() {
		return this.file = this.file.removeFilter();
	}

	public AbstractFile añadirNombre() {
		return this.file = new NombreDecorator(file);
	}

	public AbstractFile añadirExtension() {
		return this.file = new ExtensionDecorator(file);
	}

	public AbstractFile añadirTamanio() {
		return this.file = new TamanioDecorator(file);
	}

	public AbstractFile añadirFechaCreacion() {
		return this.file = new FechaCreacionDecorator(file);
	}

	public AbstractFile añadirFechaModificacion() {
		return this.file = new FechaModificacionDecorator(file);
	}

	public AbstractFile añadirPermisos() {
		return this.file = new PermisosDecorator(file);
	}
}
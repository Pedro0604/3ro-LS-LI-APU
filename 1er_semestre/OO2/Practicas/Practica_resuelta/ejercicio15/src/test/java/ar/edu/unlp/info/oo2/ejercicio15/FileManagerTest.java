package ar.edu.unlp.info.oo2.ejercicio15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo2.ejercicio15.decorators.FileCreationDateDecorator;
import ar.edu.unlp.info.oo2.ejercicio15.decorators.FileExtensionDecorator;
import ar.edu.unlp.info.oo2.ejercicio15.decorators.FileNameDecorator;
import ar.edu.unlp.info.oo2.ejercicio15.decorators.FilePermissionsDecorator;
import ar.edu.unlp.info.oo2.ejercicio15.decorators.FileSizeDecorator;

public class FileManagerTest {
	private FileManager fm;

	@BeforeEach
	void setUp() throws Exception {
		fm = new FileManager();
		File stack = new FileOO2("pepito", ".txt", 23, "rw");
		stack = new FileExtensionDecorator(stack);
		stack = new FileNameDecorator(stack);
		fm.addArchivo(stack);

		stack = new FileOO2("juju", ".pdf", 240, "rwx");
		stack = new FileCreationDateDecorator(stack);
		stack = new FileExtensionDecorator(stack);
		stack = new FileNameDecorator(stack);
		fm.addArchivo(stack);

		stack = new FileOO2("Holaaa", ".xlsx", 240223, "r");
		stack = new FileSizeDecorator(stack);
		stack = new FileExtensionDecorator(stack);
		stack = new FileNameDecorator(stack);
		stack = new FilePermissionsDecorator(stack);
		fm.addArchivo(stack);
	}

	@Test
	public void testPrettyPrint() {
		this.fm.getArchivos().forEach(a -> System.out.println(a.prettyPrint()));
	}
}

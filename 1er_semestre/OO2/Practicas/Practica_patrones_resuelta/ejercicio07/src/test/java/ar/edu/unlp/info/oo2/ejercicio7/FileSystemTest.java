package ar.edu.unlp.info.oo2.ejercicio7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileSystemTest {
	FileSystem ntfs;
	Directorio root;

	@BeforeEach
	void setUp() throws Exception {
		root = new Directorio("");
		ntfs = new FileSystem(root);
	}

	public void addArchivos(Directorio d) {
		Archivo a = new Archivo("hola.txt", 220);
		Archivo a2 = new Archivo("chau.txt", 50);
		Archivo a3 = new Archivo("adio.txt", 111);
		d.addChild(a);
		d.addChild(a2);
		d.addChild(a3);
	}

	public void addArchivosYDirectorios(Directorio d) {
		Archivo a = new Archivo("hola2.txt", 220);
		Archivo a2 = new Archivo("chau2.txt", 50);
		d.addChild(a);
		d.addChild(a2);

		Directorio d2 = new Directorio("d2");
		Archivo a3 = new Archivo("adio2.txt", 111);
		Archivo a4 = new Archivo("jelou.txt", 456);
		d2.addChild(a3);
		d2.addChild(a4);

		d.addChild(d2);
		d2.addChild(new Directorio("d3"));
	}

	@Test
	public void testTamanoTotalOcupado() {
		assertEquals(32 * 1024, ntfs.tamanoTotalOcupado());

		addArchivos(root);

		assertEquals(32 * 1024 + 381, ntfs.tamanoTotalOcupado());

		root.removeAllChildren();

		addArchivosYDirectorios(root);
		assertEquals(32 * 1024 + 270 + 32 * 1024 + 567 + 32 * 1024, ntfs.tamanoTotalOcupado());
	}

	@Test
	public void testArchivoMasGrande() {
		assertNull(ntfs.archivoMasGrande());

		addArchivos(root);
		assertNotNull(ntfs.archivoMasGrande());

		root.removeAllChildren();
		assertNull(ntfs.archivoMasGrande());

		root.addChild(new Archivo("...", 22));
		root.addChild(new Archivo("...jeje", 10234));
		Archivo masGrande = new Archivo("jojo", 10235);
		root.addChild(masGrande);
		assertEquals(masGrande, ntfs.archivoMasGrande());

		Directorio dir = new Directorio("dir");
		Archivo superMasGrande = new Archivo("jojo", 10235232);
		dir.addChild(superMasGrande);

		root.addChild(dir);
		assertEquals(superMasGrande, ntfs.archivoMasGrande());
	}

	@Test
	public void testArchivoMasNuevo() {
		assertNull(ntfs.archivoMasNuevo());

		addArchivos(root);
		assertNotNull(ntfs.archivoMasNuevo());

		root.removeAllChildren();
		assertNull(ntfs.archivoMasNuevo());

		root.addChild(new Archivo("...", 22));
		root.addChild(new Archivo("...jeje", 10234));
		Archivo masNuevo = new Archivo("jojo", 10235);
		root.addChild(masNuevo);
		assertEquals(masNuevo, ntfs.archivoMasNuevo());
	}

	@Test
	public void testBuscar() {
		assertNull(ntfs.buscar("inexistente"));
		assertEquals(root, ntfs.buscar(""));

		addArchivos(root);

		assertNotNull(ntfs.buscar("hola.txt"));

		Directorio dir = new Directorio("dir");
		Archivo jijijiji = new Archivo("jijijiji", 2343);
		dir.addChild(jijijiji);

		root.addChild(dir);
		assertEquals(jijijiji, ntfs.buscar("jijijiji"));
	}

	@Test
	public void testBuscarTodos() {
		assertEquals(0, ntfs.buscarTodos("inexistente").size());
		assertEquals(1, ntfs.buscarTodos("").size());

		addArchivos(root);

		assertEquals(1, ntfs.buscarTodos("hola.txt").size());

		Directorio dir = new Directorio("dir");
		Archivo hola = new Archivo("hola.txt", 2343);
		dir.addChild(hola);

		root.addChild(dir);
		assertEquals(2, ntfs.buscarTodos("hola.txt").size());
		assertTrue(ntfs.buscarTodos("hola.txt").contains(hola));

		root.removeAllChildren();
		addArchivos(root);

		dir = new Directorio("dir");

		root.addChild(dir);
		assertNull(ntfs.buscar("inexistenteee"));

		root.removeAllChildren();
		dir = new Directorio("dir");
		Directorio dir2 = new Directorio("dir2");
		Directorio dir3 = new Directorio("dir3");

		addArchivosYDirectorios(root);
		addArchivos(root);
		addArchivosYDirectorios(dir);
		addArchivos(dir);
		addArchivosYDirectorios(dir2);
		addArchivos(dir2);
		addArchivosYDirectorios(dir3);
		addArchivos(dir3);

		root.addChild(dir);
		dir.addChild(dir2);
		dir2.addChild(dir3);
		System.out.println(ntfs.listadoDeContenido());
	}
}

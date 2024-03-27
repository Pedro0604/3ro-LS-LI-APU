package ar.edu.unlp.info.oo2.ejercicio3;

public class test {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.agregarSocio(new Socio("Arya Stark", "needle@stark.com", "5234-5"));
		biblioteca.agregarSocio(new Socio("Tyron Lannister", "tyron@thelannisters.com", "2345-2"));
		System.out.println(biblioteca.exportarSocios());

		biblioteca.setExporter(new JsonAdapter());
		System.out.println(biblioteca.exportarSocios());

		biblioteca.setExporter(new JacksonAdapter());
		System.out.println(biblioteca.exportarSocios());
	}

}

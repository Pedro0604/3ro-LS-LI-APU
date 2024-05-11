package ar.edu.unlp.info.oo2.ejercicio21;

import java.time.LocalDate;

public class Mamifero extends AbstractMamifero {
	private String identificador, especie;
	private LocalDate fechaNacimiento;
	private AbstractMamifero madre, padre;

	protected void inicializar() {
		this.padre = new NullMamifero();
		this.madre = new NullMamifero();
		this.fechaNacimiento = LocalDate.now();
		this.especie = "";
		this.identificador = "";
	}

	public Mamifero(String identificador, String especie, LocalDate fechaNacimiento, AbstractMamifero madre,
			AbstractMamifero padre) {
		super();
		this.identificador = identificador;
		this.especie = especie;
		this.fechaNacimiento = fechaNacimiento;
		this.madre = madre;
		this.padre = padre;
	}

	public Mamifero() {
		this.inicializar();
	}

	public Mamifero(String identificador) {
		this.inicializar();
		this.identificador = identificador;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public AbstractMamifero getMadre() {
		return madre;
	}

	public void setMadre(AbstractMamifero madre) {
		this.madre = madre;
	}

	public AbstractMamifero getPadre() {
		return padre;
	}

	public void setPadre(AbstractMamifero padre) {
		this.padre = padre;
	}

	public AbstractMamifero getAbueloMaterno() {
		return this.madre.getPadre();
	}

	public AbstractMamifero getAbuelaMaterna() {
		return this.madre.getMadre();
	}

	public AbstractMamifero getAbueloPaterno() {
		return this.padre.getPadre();
	}

	public AbstractMamifero getAbuelaPaterna() {
		return this.padre.getMadre();
	}

	public boolean tieneComoAncestroA(AbstractMamifero otroMamifero) {
		return this.madre == otroMamifero || this.padre == otroMamifero || this.madre.tieneComoAncestroA(otroMamifero)
				|| this.padre.tieneComoAncestroA(otroMamifero);
	}
}

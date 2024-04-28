package ar.edu.unlp.info.oo2.ejercicio21;

import java.time.LocalDate;

public class NullMamifero extends AbstractMamifero {
	@Override
	public String getIdentificador() {
		return "";
	}

	@Override
	public void setIdentificador(String identificador) {
	}

	@Override
	public String getEspecie() {
		return "";
	}

	@Override
	public void setEspecie(String especie) {
	}

	@Override
	public LocalDate getFechaNacimiento() {
		return LocalDate.now();
	}

	@Override
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
	}

	@Override
	public AbstractMamifero getMadre() {
		return new NullMamifero();
	}

	@Override
	public void setMadre(AbstractMamifero madre) {
	}

	@Override
	public AbstractMamifero getPadre() {
		return new NullMamifero();
	}

	@Override
	public void setPadre(AbstractMamifero padre) {
	}

	@Override
	public AbstractMamifero getAbueloMaterno() {
		return new NullMamifero();
	}

	@Override
	public AbstractMamifero getAbuelaMaterna() {
		return new NullMamifero();
	}

	@Override
	public AbstractMamifero getAbueloPaterno() {
		return new NullMamifero();
	}

	@Override
	public AbstractMamifero getAbuelaPaterna() {
		return new NullMamifero();
	}

	@Override
	public boolean tieneComoAncestroA(AbstractMamifero otroMamifero) {
		return false;
	}
}

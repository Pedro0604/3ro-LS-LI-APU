package ar.edu.unlp.info.oo2.ejercicio21;

import java.time.LocalDate;

public abstract class AbstractMamifero {
	public abstract String getIdentificador();

	public abstract void setIdentificador(String identificador);

	public abstract String getEspecie();

	public abstract void setEspecie(String especie);

	public abstract LocalDate getFechaNacimiento();

	public abstract void setFechaNacimiento(LocalDate fechaNacimiento);

	public abstract AbstractMamifero getMadre();

	public abstract void setMadre(AbstractMamifero madre);

	public abstract AbstractMamifero getPadre();

	public abstract void setPadre(AbstractMamifero padre);

	public abstract AbstractMamifero getAbueloMaterno();

	public abstract AbstractMamifero getAbuelaMaterna();

	public abstract AbstractMamifero getAbueloPaterno();

	public abstract AbstractMamifero getAbuelaPaterna();

	public abstract boolean tieneComoAncestroA(AbstractMamifero otroMamifero);
}

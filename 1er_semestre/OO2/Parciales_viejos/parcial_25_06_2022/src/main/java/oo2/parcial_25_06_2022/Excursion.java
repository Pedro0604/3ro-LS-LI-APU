package oo2.parcial_25_06_2022;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Excursion {
	private String nombre;
	private LocalDateTime fechaInicio, fechaFin;
	private String puntoEncuentro;
	private double costo;
	private int cupoMin, cupoMax;
	private List<Usuario> usuarios, listaEspera;
	private ExcursionState state;

	public Excursion(String nombre, LocalDateTime fechaInicio, LocalDateTime fechaFin, String puntoEncuentro,
			double costo, int cupoMin, int cupoMax) {
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.puntoEncuentro = puntoEncuentro;
		this.costo = costo;
		this.cupoMin = cupoMin;
		this.cupoMax = cupoMax;
		this.usuarios = new ArrayList<>();
		this.listaEspera = new ArrayList<>();
		this.state = new ProvisoriaState(this);
	}

	public int getCupoMin() {
		return cupoMin;
	}

	public int getCupoMax() {
		return cupoMax;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public String getPuntoEncuentro() {
		return puntoEncuentro;
	}

	public double getCosto() {
		return costo;
	}

	public ExcursionState getState() {
		return state;
	}

	public void setState(ExcursionState state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Excursion [nombre=" + nombre + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", puntoEncuentro=" + puntoEncuentro + ", costo=" + costo + ", cupoMin=" + cupoMin + ", cupoMax="
				+ cupoMax + ", usuarios=" + usuarios + ", listaEspera=" + listaEspera + ", state=" + state + "]";
	}

	public void addUsuario(Usuario unUsuario) {
		this.usuarios.add(unUsuario);
	}

	public void addUsuarioToListaDeEspera(Usuario unUsuario) {
		this.listaEspera.add(unUsuario);
	}

	public int getCantidadUsuarios() {
		return this.usuarios.size();
	}

	public int getCantidadUsuariosListaDeEspera() {
		return this.listaEspera.size();
	}

	public int getUsuariosHastaCupoMin() {
		return this.getCupoMin() - this.getCantidadUsuarios();
	}

	public int getUsuariosHastaCupoMax() {
		return this.getCupoMax() - this.getCantidadUsuarios();
	}

	public void inscribir(Usuario unUsuario) {
		this.state.inscribir(unUsuario);
	}

	public String obtenerInformacion() {
		return this.state.obtenerInformacion();
	}

	public String getMailsUsuarios() {
		return this.usuarios.stream().map(usuario -> usuario.getEmail()).reduce("",
				(email1, email2) -> email1 + " - " + email2);
	}
}

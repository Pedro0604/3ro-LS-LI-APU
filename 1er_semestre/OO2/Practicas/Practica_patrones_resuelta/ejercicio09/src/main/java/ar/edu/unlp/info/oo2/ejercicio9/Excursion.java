package ar.edu.unlp.info.oo2.ejercicio9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Excursion {
	private String nombre, puntoEncuentro;
	private LocalDate fechaInicio, fechaFin;
	private double costo;
	private int cupoMin, cupoMax;
	private List<Usuario> usuarios;
	private List<Usuario> listaEspera;
	private ExcursionState state;

	public Excursion(String nombre, LocalDate fechaInicio, LocalDate fechaFin, String puntoEncuentro, double costo,
			int cupoMin, int cupoMax) {
		this.nombre = nombre;
		this.puntoEncuentro = puntoEncuentro;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costo = costo;
		this.cupoMin = cupoMin;
		this.cupoMax = cupoMax;
		this.usuarios = new ArrayList<>();
		this.listaEspera = new ArrayList<>();
		this.state = new Provisoria(this);
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<Usuario> getListaEspera() {
		return listaEspera;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPuntoEncuentro() {
		return puntoEncuentro;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public double getCosto() {
		return costo;
	}

	public void setState(ExcursionState state) {
		this.state = state;
	}

	public boolean isAtCupoMin() {
		return this.getCantUsuarios() == this.cupoMin;
	}

	public boolean isAtCupoMax() {
		return this.getCantUsuarios() == this.cupoMax;
	}

	public int getCantUsuarios() {
		return this.getUsuarios().size();
	}

	public int getCantUsuariosToCupoMin() {
		return this.cupoMin - this.getCantUsuarios();
	}

	public int getCantUsuariosToCupoMax() {
		return this.cupoMax - this.getCantUsuarios();
	}

	public String getAllMails() {
		return this.usuarios.stream().map(u -> "email=" + u.getEmail()).collect(Collectors.joining(", "));
	}

	public void addUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	public void addUsuarioToListaEspera(Usuario usuario) {
		this.listaEspera.add(usuario);
	}

	public void inscribirUsuario(Usuario usuario) {
		this.state.inscribirUsuario(usuario);
	}

	@Override
	public String toString() {
		return this.state.toString();
	}
}

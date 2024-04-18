package ar.edu.unlp.info.oo2.ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Twitter {
	private List<Usuario> usuarios;

	public Twitter() {
		this.usuarios = new ArrayList<>();
	}

	public Usuario registrarUsuario(String screenName) {
		if (this.existeScreenName(screenName)) {
			return null;
		}
		Usuario u = new Usuario(screenName);
		this.usuarios.add(u);
		return u;
	}

	private boolean existeScreenName(String screenName) {
		return this.usuarios.stream().anyMatch(u -> u.getScreenName().equals(screenName));
	}

	public boolean eliminarUsuario(String screenName) {
		if (!this.existeScreenName(screenName)) {
			return false;
		}
		Usuario usuario = this.usuarios.stream().filter(u -> u.getScreenName().equals(screenName))
				.collect(Collectors.toList()).get(0);
		this.eliminarReferencias(usuario.getTweets());
		return this.usuarios.remove(usuario);
	}

	private void eliminarReferencias(List<Tweetable> tweets) {
		this.usuarios.forEach(u -> u.eliminarReferencias(tweets));
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
}

package ar.edu.unlp.info.oo2.ejercicio_25;

import java.util.List;

public interface PersistableUser {

	public String getUsername();

	public String getEmail();

	public List<Post> getPosts();

}

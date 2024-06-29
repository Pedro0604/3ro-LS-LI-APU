package ar.edu.unlp.info.oo2.ejercicio_25;

import java.util.List;

public class UserProxy implements PersistableUser {
	private User user;

	public UserProxy(User user) {
		this.user = user;
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public String getEmail() {
		return this.user.getEmail();
	}

	@Override
	public List<Post> getPosts() {
		this.user.addPosts((new PostRepository()).findPostsByUsername(this.user.getUsername()));
		return this.user.getPosts();
	}
}

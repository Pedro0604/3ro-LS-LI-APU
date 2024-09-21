package clasesDAOImpljdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clasesDAO.UsuarioDAO;
import clasesObjetosSistema.Usuario;
import dataSource.MiDataSource;

public class UsuarioDAOjdbc implements UsuarioDAO {

	@Override
	public Usuario get(long id) {
		Usuario usuario = null;
		try {
			Connection con = MiDataSource.getDataSource().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT id, nombre, apellido, email FROM usuarios WHERE id='" + id + "'");
			if (rs.next() == true) {
				usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getString("email"));
			}
			rs.close();
			st.close();
			con.close();
		} catch (java.sql.SQLException e) {
			System.out.println("Error de SQL: " + e.getMessage());
		}
		return usuario;
	}

	@Override
	public List<Usuario> load() {
		List<Usuario> usuarios = new ArrayList<>();
		try {
			Connection con = MiDataSource.getDataSource().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT id, nombre, apellido, email FROM usuarios");
			UsuarioDAO uDAO = FactoryDAO.getUsuarioDAO();
			while (rs.next() == true) {
				usuarios.add(new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getString("email")));
			}
			rs.close();
			st.close();
			con.close();
		} catch (java.sql.SQLException e) {
			System.out.println("Error de SQL: " + e.getMessage());
		}
		return usuarios;
	}
}

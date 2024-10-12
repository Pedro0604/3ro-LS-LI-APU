package clasesDAOImpljdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clasesDAO.MensajesDAO;
import clasesDAO.UsuarioDAO;
import clasesObjetosSistema.Mensaje;
import dataSource.MiDataSource;

public class MensajesDAOjdbc implements MensajesDAO {

	@Override
	public List<Mensaje> load() {
		List<Mensaje> mensajes = new ArrayList<>();
		try {
			Connection con = MiDataSource.getDataSource().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT mensaje, id_usuario FROM mensajes");
			UsuarioDAO uDAO = FactoryDAO.getUsuarioDAO();
			while (rs.next() == true) {
				mensajes.add(new Mensaje(rs.getString("mensaje"), uDAO.get(rs.getInt("id_usuario"))));
			}
			rs.close();
			st.close();
			con.close();
		} catch (java.sql.SQLException e) {
			System.out.println("Error de SQL: " + e.getMessage());
		}
		return mensajes;
	}

	@Override
	public Mensaje get(int id) {
		Mensaje mensaje = null;
		try {
			Connection con = MiDataSource.getDataSource().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT mensaje, id_usuario FROM mensajes WHERE id='" + id + "'");
			if (rs.next() == true) {
				UsuarioDAO uDAO = FactoryDAO.getUsuarioDAO();
				mensaje = new Mensaje(rs.getString("mensaje"), uDAO.get(rs.getInt("id_usuario")));
			}
			rs.close();
			st.close();
			con.close();
		} catch (java.sql.SQLException e) {
			System.out.println("Error de SQL: " + e.getMessage());
		}
		return mensaje;
	}

	@Override
	public boolean save(Mensaje mensaje) {
		boolean exito = false;
		try {
			Connection con = MiDataSource.getDataSource().getConnection();
			Statement st = con.createStatement();
			int res = st.executeUpdate("INSERT INTO mensajes (mensaje, id_usuario) values ('" + mensaje.getMensaje()
					+ "', '" + mensaje.getUsuario().getId() + "')");
			if (res == 1) {
				exito = true;
			}
			st.close();
			con.close();
		} catch (java.sql.SQLException e) {
			System.out.println("Error de SQL: " + e.getMessage());
		}
		return exito;
	}

}

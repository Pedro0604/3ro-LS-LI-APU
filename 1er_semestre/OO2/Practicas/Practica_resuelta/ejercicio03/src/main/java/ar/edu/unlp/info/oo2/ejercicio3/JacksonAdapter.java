package ar.edu.unlp.info.oo2.ejercicio3;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonAdapter extends VoorheesExporter {

	private ObjectMapper objectMapperAdaptee;

	public JacksonAdapter() {
		objectMapperAdaptee = new ObjectMapper();
	}

	@Override
	public String exportar(List<Socio> socios) {
		try {
			return objectMapperAdaptee.writeValueAsString(socios);
		} catch (Exception e) {
			return "Exception: " + e.getMessage();
		}

		/*
		 * socios.forEach(s -> { Map<String, String> map = new HashMap<>();
		 * map.put("nombre", s.getNombre()); map.put("email", s.getEmail());
		 * map.put("legajo", s.getLegajo()); JsonObjectAdaptee.putAll(map);
		 * JsonArrayAdaptee.add(JsonObjectAdaptee); JsonObjectAdaptee = new
		 * JSONObject(); }); String str = JsonArrayAdaptee.toJSONString();
		 * JsonArrayAdaptee = new JSONArray(); return str;
		 */
	}
}
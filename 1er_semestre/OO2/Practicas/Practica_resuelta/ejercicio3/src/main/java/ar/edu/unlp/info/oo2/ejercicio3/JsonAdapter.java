package ar.edu.unlp.info.oo2.ejercicio3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonAdapter extends VoorheesExporter {
	private JSONObject JsonObjectAdaptee;
	private JSONArray JsonArrayAdaptee;

	public JsonAdapter() {
		JsonObjectAdaptee = new JSONObject();
		JsonArrayAdaptee = new JSONArray();
	}

	@Override
	public String exportar(List<Socio> socios) {
		socios.forEach(s -> {
			Map<String, String> map = new HashMap<>();
			map.put("nombre", s.getNombre());
			map.put("email", s.getEmail());
			map.put("legajo", s.getLegajo());
			JsonObjectAdaptee.putAll(map);
			JsonArrayAdaptee.add(JsonObjectAdaptee);
			JsonObjectAdaptee = new JSONObject();
		});
		String str = JsonArrayAdaptee.toJSONString();
		JsonArrayAdaptee = new JSONArray();
		return str;
	}
}

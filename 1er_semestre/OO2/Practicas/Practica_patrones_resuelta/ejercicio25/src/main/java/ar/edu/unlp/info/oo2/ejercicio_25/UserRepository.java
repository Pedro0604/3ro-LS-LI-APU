package ar.edu.unlp.info.oo2.ejercicio_25;

import java.io.FileReader;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UserRepository {

	@SuppressWarnings("unchecked")
	public PersistableUser findUserByUsername(String aUsername) {
		JSONParser parser = new JSONParser();
		try {
			List<JSONObject> usersData = (List<JSONObject>) parser.parse(new FileReader("users.json"));
			User user = usersData.stream().filter(userData -> userData.get("username").equals(aUsername)).findFirst()
					.map(userData -> new User((String) userData.get("username"), (String) userData.get("email")))
					.orElse(null);
			return (new UserProxy(user));
		} catch (Exception e) {
			return null;
		}
	}

}

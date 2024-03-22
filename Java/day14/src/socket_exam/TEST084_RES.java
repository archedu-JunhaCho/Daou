package socket_exam;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TEST084_RES implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Map<String, String> response = new HashMap<>();
	
	public void put(String key, String value) {
		this.response.put(key, value);
	}

	@Override
	public String toString() {
		return "\n[\n" + response + "\n]";
	}
	
}

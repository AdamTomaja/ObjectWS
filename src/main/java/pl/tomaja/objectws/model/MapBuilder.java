package pl.tomaja.objectws.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Adam Tomaja
 */
public class MapBuilder {

	public static Map<Object, Object> newHashMap(Object ... params) {
		Map<Object, Object> map = new HashMap<>();
		if(params.length % 2 != 0) {
			throw new RuntimeException("Parameters count must be even!");
		}
		
		for(int i = 0; i < params.length; i += 2) {
			map.put(params[i], params[i + 1]);
		}
		
		return map;
	}
}

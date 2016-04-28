package pl.tomaja.objectws.app;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.tomaja.objectws.model.ExecutionEnvironment;
import pl.tomaja.objectws.model.ExecutionRequest;

public class TestObject {

	private final Logger LOGGER = LoggerFactory.getLogger(TestObject.class);
	
	public void doSum(ExecutionEnvironment envs) {
		Double a = envs.getDoubleParameter("a");
		Double b = envs.getDoubleParameter("b");

		LOGGER.info("Summing {} and {b}", a, b);

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("result", a + b);
		
		envs.send(new ExecutionRequest("application", "receiveSum", parameters));
	}
}

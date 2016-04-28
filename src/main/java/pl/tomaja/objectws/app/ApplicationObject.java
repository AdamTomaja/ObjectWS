package pl.tomaja.objectws.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.tomaja.objectws.model.ExecutionEnvironment;
import pl.tomaja.objectws.model.ExecutionRequest;

public class ApplicationObject {

	private final Logger LOGGER = LoggerFactory.getLogger(ApplicationObject.class);
	
	public void doSum(ExecutionEnvironment envs) {
		Double a = envs.getDoubleParameter("a");
		Double b = envs.getDoubleParameter("b");

		LOGGER.info("Summing {} and {}", a, b);
		
		envs.send(new ExecutionRequest("application", "receiveSum", null)
				.addParameter("result", a + b));
	}
	
	public void getDescription() {
		
	}
}

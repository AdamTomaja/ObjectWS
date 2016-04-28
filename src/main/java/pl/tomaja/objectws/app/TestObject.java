package pl.tomaja.objectws.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.tomaja.objectws.model.ExecutionEnvironment;

public class TestObject {

	private final Logger LOGGER = LoggerFactory.getLogger(TestObject.class);
	
	public void doSum(ExecutionEnvironment envs) {
		LOGGER.info("Summing");
	}
}

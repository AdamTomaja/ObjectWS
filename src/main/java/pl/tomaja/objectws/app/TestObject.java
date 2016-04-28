package pl.tomaja.objectws.app;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.tomaja.objectws.model.ExecutionEnvironment;
import pl.tomaja.objectws.model.ExecutionRequest;

public class TestObject {

	private final Logger LOGGER = LoggerFactory.getLogger(TestObject.class);
	
	public void doSum(ExecutionEnvironment envs) {
		LOGGER.info("Summing");
		envs.send(new ExecutionRequest("sumResultReceiver", "receive", Arrays.asList(2 + 5)));
	}
}

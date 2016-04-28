package pl.tomaja.objectws.app;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.tomaja.objectws.model.ExecutionEnvironment;
import pl.tomaja.objectws.model.ExecutionRequest;

public class TestObject {

	private final Logger LOGGER = LoggerFactory.getLogger(TestObject.class);
	
	public void doSum(ExecutionEnvironment envs) {
		Double a = (Double) envs.getRequest().getParameters().get(0);
		Double b = (Double) envs.getRequest().getParameters().get(1);
		
		envs.send(new ExecutionRequest("application", "receiveSum", Arrays.asList(a + b)));
	}
}

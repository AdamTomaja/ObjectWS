package pl.tomaja.objectws.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.tomaja.objectws.model.ExecutionEnvironment;

public class ObjectWSObject {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ObjectWSObject.class);

	public void receiveError(ExecutionEnvironment env) {
		LOGGER.error("Error received: {}", env);
	}
}

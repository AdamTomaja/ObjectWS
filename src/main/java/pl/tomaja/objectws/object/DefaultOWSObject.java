package pl.tomaja.objectws.object;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.tomaja.objectws.model.ExecutionEnvironment;

/**
 * @author Adam Tomaja
 */
public class DefaultOWSObject {
	
	private final Logger LOGGER = LoggerFactory.getLogger(DefaultOWSObject.class);

	public void receiveError(ExecutionEnvironment env) {
		LOGGER.error("Error received: {}", env);
	}
}

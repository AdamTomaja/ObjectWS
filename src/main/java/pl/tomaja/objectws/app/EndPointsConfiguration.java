package pl.tomaja.objectws.app;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.tomaja.objectws.ws.ObjectWSWebSocketHandler;

@Component
public class EndPointsConfiguration {

	@Autowired
	private ObjectWSWebSocketHandler handler;
	
	@PostConstruct
	public void init() {
		handler.registerObject("application", new TestObject());
	}
}

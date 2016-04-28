package pl.tomaja.objectws.app;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.tomaja.objectws.ws.WebSocketHandler;

@Component
public class EndPointsConfiguration {

	@Autowired
	private WebSocketHandler handler;
	
	@PostConstruct
	public void init() {
		handler.registerObject("test", new TestObject());
	}
}

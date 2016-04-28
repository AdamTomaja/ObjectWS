package pl.tomaja.objectws.model;

import org.springframework.web.socket.WebSocketSession;

import pl.tomaja.objectws.ws.WebSocketHandler;

public class ExecutionEnvironment {

	private WebSocketSession session;
	
	private ExecutionRequest request;
	
	private WebSocketHandler handler;

	public ExecutionEnvironment(WebSocketSession session, ExecutionRequest request, WebSocketHandler handler) {
		this.session = session;
		this.request = request;
		this.handler = handler;
	}

	public WebSocketSession getSession() {
		return session;
	}

	public void setSession(WebSocketSession session) {
		this.session = session;
	}

	public ExecutionRequest getRequest() {
		return request;
	}

	public void setRequest(ExecutionRequest request) {
		this.request = request;
	}
	
	public void send(ExecutionRequest request) {
		handler.send(session, request);
	}
}

package pl.tomaja.objectws.model;

import org.springframework.web.socket.WebSocketSession;

public class ExecutionEnvironment {

	private WebSocketSession session;
	
	private ExecutionRequest request;

	public ExecutionEnvironment(WebSocketSession session, ExecutionRequest request) {
		this.session = session;
		this.request = request;
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
}

package pl.tomaja.objectws.model;

import org.springframework.web.socket.WebSocketSession;

import pl.tomaja.objectws.ws.ObjectWSWebSocketHandler;

public class ExecutionEnvironment {

	private WebSocketSession session;
	
	private ExecutionRequest request;
	
	private ObjectWSWebSocketHandler handler;

	public ExecutionEnvironment(WebSocketSession session, ExecutionRequest request, ObjectWSWebSocketHandler handler) {
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

	@Override
	public String toString() {
		return "ExecutionEnvironment [request=" + request + "]";
	}
	
	public Double getDoubleParameter(String name) {
		return (Double) getParameter(name);
	}
	
	public Object getParameter(String name) {
		return request.getParameters().get(name);
	}
}

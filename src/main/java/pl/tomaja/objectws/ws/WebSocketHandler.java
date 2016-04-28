package pl.tomaja.objectws.ws;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;

import pl.tomaja.objectws.model.ExecutionEnvironment;
import pl.tomaja.objectws.model.ExecutionRequest;
import pl.tomaja.objectws.model.ExecutionResult;

@Component
public class WebSocketHandler extends TextWebSocketHandler {

	private final Logger LOGGER = LoggerFactory.getLogger(WebSocketHandler.class);
	
	private final Gson gson = new Gson();
	
	private final Map<String, Object> objects = new HashMap<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		LOGGER.info("New connection");
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		ExecutionResult result;
		try {
			ExecutionRequest request = gson.fromJson(message.getPayload(), ExecutionRequest.class);
			LOGGER.info("Request: {}", request);
			Object object = getObject(request);
			execute(object, new ExecutionEnvironment(session, request));
			result = ExecutionResult.createOk();
		} catch (Exception e) {
			LOGGER.error("Unable to execute request", e);
			result = ExecutionResult.createError(e);
		}
		
		session.sendMessage(new TextMessage(gson.toJson(result)));
	}
	
	private void execute(Object object, ExecutionEnvironment environment) {
		LOGGER.info("Executing {} on {}", environment.getRequest(), object);
		try {
			Method method = object.getClass()
					.getMethod(environment.getRequest().getMethod(), ExecutionEnvironment.class);
			
			method.invoke(object, environment);
		} catch (NoSuchMethodException | 
				SecurityException | 
				IllegalAccessException | 
				IllegalArgumentException | 
				InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	private Object getObject(ExecutionRequest request) {
		return Objects.requireNonNull(objects.get(request.getObject()));
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		LOGGER.info("Connection closed");
	}
	
	public void registerObject(String name, Object object) {
		objects.put(name,  object);
	}
}
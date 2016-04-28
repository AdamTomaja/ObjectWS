package pl.tomaja.objectws.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Adam Tomaja
 */
public class ExecutionRequest {

	private String object;
	private String method;
	private Map<String, Object> parameters;
	
	public ExecutionRequest() {

	}

	public ExecutionRequest(String object, String method, Map<String, Object> parameters) {
		this.object = object;
		this.method = method;
		this.parameters = parameters;
	}
	
	public ExecutionRequest(String object, String method) {
		this.object = object;
		this.method = method;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getMethod() {
		return method;
	}
	
	public void setMethod(String method) {
		this.method = method;
	}
	
	public Map<String, Object> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}
	
	public ExecutionRequest addParameter(String name, Object value) {
		if(parameters == null) {
			parameters = new HashMap<>();
		}
		
		parameters.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return "ExecutionRequest [object=" + object + ", method=" + method + ", parameters=" + parameters + "]";
	}
}

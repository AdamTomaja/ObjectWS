package pl.tomaja.objectws.model;

import java.util.List;

public class ExecutionRequest {

	private String object;
	private String method;
	private List<Object> parameters;
	
	public ExecutionRequest() {

	}

	public ExecutionRequest(String object, String method, List<Object> parameters) {
		this.object = object;
		this.method = method;
		this.parameters = parameters;
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
	
	public List<Object> getParameters() {
		return parameters;
	}

	public void setParameters(List<Object> parameters) {
		this.parameters = parameters;
	}

	@Override
	public String toString() {
		return "ExecutionRequest [object=" + object + ", method=" + method + ", parameters=" + parameters + "]";
	}
}

package pl.tomaja.objectws.api;

import pl.tomaja.objectws.model.ExecutionRequest;

public interface ObjectWSEndpoint {
	
	void execute(ExecutionRequest request);

}

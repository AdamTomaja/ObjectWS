package pl.tomaja.objectws.model;

/**
 * @author Adam Tomaja
 */
public class ExecutionResult {

	private ResultType type;
	
	private Throwable throwable;

	public ResultType getType() {
		return type;
	}

	public void setType(ResultType type) {
		this.type = type;
	}
	
	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	public static ExecutionResult createOk() {
		ExecutionResult result = new ExecutionResult();
		result.setType(ResultType.OK);
		return result;
	}
	
	public static ExecutionResult createError(Throwable throwable) {
		ExecutionResult result = new ExecutionResult();
		result.setType(ResultType.ERROR);
		result.setThrowable(throwable);
		return result;
	}
}

package lk.accio.sample.exception;

public class ForbiddenAccessException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6525225690162870161L;

	public ForbiddenAccessException() {
		
	}

	public ForbiddenAccessException(String message) {
		super(message);
	}
}

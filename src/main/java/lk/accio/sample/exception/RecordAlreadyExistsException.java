package lk.accio.sample.exception;

public class RecordAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3059097842750040939L;

	public RecordAlreadyExistsException() {
		
	}

	public RecordAlreadyExistsException(String message) {
		super(message);
	}

}

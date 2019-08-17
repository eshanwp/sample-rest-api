package lk.accio.sample.exception;

public class RecordNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3059097842750040939L;

	public RecordNotFoundException() {

	}

	public RecordNotFoundException(String message) {
		super(message);
	}

}

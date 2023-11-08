package servicio;

public class ActoresServicesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActoresServicesException() {
		
	}

	public ActoresServicesException(String message) {
		super(message);
	}

	public ActoresServicesException(Throwable cause) {
		super(cause);
	}

	public ActoresServicesException(String message, Throwable cause) {
		super(message, cause);
	}

	public ActoresServicesException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

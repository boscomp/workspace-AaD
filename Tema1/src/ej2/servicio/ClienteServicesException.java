package ej2.servicio;

public class ClienteServicesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteServicesException() {
	}

	public ClienteServicesException(String message) {
		super(message);

	}

	public ClienteServicesException(Throwable cause) {
		super(cause);

	}

	public ClienteServicesException(String message, Throwable cause) {
		super(message, cause);

	}

	public ClienteServicesException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}

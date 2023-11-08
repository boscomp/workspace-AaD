package ej3.services;

public class PagoServicesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PagoServicesException() {
	}

	public PagoServicesException(String message) {
		super(message);

	}

	public PagoServicesException(Throwable cause) {
		super(cause);

	}

	public PagoServicesException(String message, Throwable cause) {
		super(message, cause);

	}

	public PagoServicesException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}

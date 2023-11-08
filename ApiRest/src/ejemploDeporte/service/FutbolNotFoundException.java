package ejemploDeporte.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FutbolNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FutbolNotFoundException() {
	}

	public FutbolNotFoundException(String message) {
		super(message);

	}

	public FutbolNotFoundException(Throwable cause) {
		super(cause);

	}

	public FutbolNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public FutbolNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}

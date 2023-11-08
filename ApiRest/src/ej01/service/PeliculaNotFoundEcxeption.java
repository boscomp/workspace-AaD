package ej01.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PeliculaNotFoundEcxeption extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PeliculaNotFoundEcxeption() {
	}

	public PeliculaNotFoundEcxeption(String message) {
		super(message);

	}

	public PeliculaNotFoundEcxeption(Throwable cause) {
		super(cause);

	}

	public PeliculaNotFoundEcxeption(String message, Throwable cause) {
		super(message, cause);

	}

	public PeliculaNotFoundEcxeption(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}

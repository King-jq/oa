package com.jmsj.sys.exception;

public class UserException extends RuntimeException {

	public UserException() {
		super();
	}

	public UserException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause);
	}

	public UserException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserException(String message) {
		super(message);
	}

	public UserException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = 1L;

}

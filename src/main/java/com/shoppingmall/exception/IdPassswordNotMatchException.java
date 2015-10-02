package com.shoppingmall.exception;

public class IdPassswordNotMatchException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public IdPassswordNotMatchException() {
		super();
	}
	public IdPassswordNotMatchException(String message) {
		super(message);
	}
	public IdPassswordNotMatchException(Throwable cause) {
		super(cause);
	}
	public IdPassswordNotMatchException(String message, Throwable cause) {
		super(message, cause);
	}
}

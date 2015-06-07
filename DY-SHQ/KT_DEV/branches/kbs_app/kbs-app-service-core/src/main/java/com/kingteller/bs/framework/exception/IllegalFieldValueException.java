package com.kingteller.bs.framework.exception;

public class IllegalFieldValueException extends IllegalArgumentException {

	private static final long serialVersionUID = 2845232821410771336L;

	public IllegalFieldValueException() {
        super();
    }

    public IllegalFieldValueException(String s) {
        super(s);
    }

    public IllegalFieldValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalFieldValueException(Throwable cause) {
        super(cause);
    }
}

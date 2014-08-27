package com.sms.web.exception;

public class SMSWebException extends Exception {
	 
    private String message = null;
 
    public SMSWebException() {
        super();
    }
 
    public SMSWebException(String message) {
        super(message);
        this.message = message;
    }
 
    public SMSWebException(Throwable cause) {
        super(cause);
    }
 
    @Override
    public String toString() {
        return message;
    }
 
    @Override
    public String getMessage() {
        return message;
    }
}

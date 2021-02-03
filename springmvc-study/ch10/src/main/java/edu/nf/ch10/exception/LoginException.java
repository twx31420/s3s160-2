package edu.nf.ch10.exception;

/**
 * @author 天文学
 * @date 2021/1/13
 */
public class LoginException extends RuntimeException{
    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginException(Throwable cause) {
        super(cause);
    }
}

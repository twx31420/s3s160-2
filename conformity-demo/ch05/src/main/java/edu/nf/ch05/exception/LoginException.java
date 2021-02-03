package edu.nf.ch05.exception;

/**
 * @author 天文学
 * @date 2021/1/21
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

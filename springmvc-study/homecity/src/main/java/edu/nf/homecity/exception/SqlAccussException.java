package edu.nf.homecity.exception;

/**
 * @author 天文学
 * @date 2021/1/17
 */
public class SqlAccussException extends RuntimeException{
    public SqlAccussException(String message) {
        super(message);
    }

    public SqlAccussException(String message, Throwable cause) {
        super(message, cause);
    }

    public SqlAccussException(Throwable cause) {
        super(cause);
    }
}

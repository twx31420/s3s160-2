package edu.nf.ch09_hw.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author 天文学
 * @date 2021/1/12
 */
public class SqlDataAccessException extends RuntimeException{

    public SqlDataAccessException(String message) {
        super(message);
    }

    public SqlDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public SqlDataAccessException(Throwable cause) {
        super(cause);
    }
}

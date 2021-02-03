package edu.nf.ch03.exception;

/**
 * @author 天文学
 * @date 2021/1/19
 */
public class TransferException extends RuntimeException{
    public TransferException(String message) {
        super(message);
    }

    public TransferException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransferException(Throwable cause) {
        super(cause);
    }
}

package edu.nf.ch09.exceptioon;

/**
 * @author 天文学
 * @date 2021/1/12
 * 自定义数据库访问异常
 */
public class DataAccessException extends RuntimeException {

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException(Throwable cause) {
        super(cause);
    }
}

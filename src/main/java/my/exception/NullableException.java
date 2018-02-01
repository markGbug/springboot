package my.exception;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/29
 */
public class NullableException extends Exception {

    private String code;

    private String message;

    public NullableException() {
    }

    public NullableException(String message) {
        super(message);
    }

    public NullableException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullableException(Throwable cause) {
        super(cause);
    }

    public NullableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public NullableException(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
}

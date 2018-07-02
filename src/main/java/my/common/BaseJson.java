package my.common;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/19
 */
public class BaseJson<T> {

    private String code = "0";

    private String message;

    private T data;

    private Boolean ifSuccess;

    public String getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }


    public void setResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.ifSuccess = BaseConstants.RespCode.SUCCESS.equals(code);
    }

    public void setFailResult(String code, String message) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.ifSuccess = false;
    }

    public void setSuccessResult(String message, T data) {
        this.code = BaseConstants.RespCode.SUCCESS;
        this.message = message;
        this.data = data;
        this.ifSuccess = true;
    }


    public void setResult(String code, String message) {
        this.code = code;
        this.message = message;
        this.ifSuccess = BaseConstants.RespCode.SUCCESS.equals(code);
    }

    public Boolean ifSuccess() {
        return ifSuccess;
    }

    public Boolean getIfSuccess() {
        return ifSuccess;
    }
}

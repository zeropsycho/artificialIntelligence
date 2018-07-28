package share.exception;

/**
 * @author ZERO
 * @version V1.0
 * @description 返回参数格式
 * @package share.exception
 * @date 2018 07-18 15:56
 */
public class ReturnFormat {

    private String code;

    private String message;

    private String remark;

    private Object data;

    public ReturnFormat() {
    }

    public ReturnFormat(String code) {
        this.code = code;
    }

    public ReturnFormat(String code, Object data) {
        this.code = code;
        this.data = data;
    }

    public ReturnFormat(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ReturnFormat(String code, String message, String remark, Object data) {
        this.code = code;
        this.message = message;
        this.remark = remark;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ReturnFormat{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", remark='" + remark + '\'' +
                ", data=" + data +
                '}';
    }
}

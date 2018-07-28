package share.enums;

/**
 * @author ZERO
 * @version V1.0
 * @description 状态码
 * @package share.enums
 * @date 2018 07-18 16:04
 */
public enum StatusCode {

    SUCCESS("10000000", "SUCCESS"),
    ERRCODE("10000001", "未知异常"),

    ADD_SUCCESS("10000000", "添加成功"),
    ADD_FAILURE("20000000", "添加失败"),

    QUERY_SUCCESS("10000000", "查询成功"),
    QUERY_FAILURE("20000000", "查询失败"),

    UPDATE_SUCCESS("10000000", "更新成功"),
    UPDATE_FAILURE("20000000", "更新失败"),

    DELETE_SUCCESS("10000000", "删除成功"),
    DELETE_FAILURE("20000000", "删除失败");

    private String code;

    private String message;

    private String remark;

    StatusCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过code 获取message
     */
    public static String getMessage(String code) {
        for (StatusCode statusCode : StatusCode.values()) {
            if (statusCode.getCode().equals(code)) {
                return statusCode.message;
            }
        }
        return null;
    }

    StatusCode(String code, String message, String remark) {
        this.code = code;
        this.message = message;
        this.remark = remark;
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
}
package share.constant;

/**
 * @author WenHui Li
 * @version V1.0
 * @ClassName: RequestHeader.java
 * @description：
 * @date 2018 07-18 11:18
 */
public class RequestHeader {
    private static final String REQUEST_HEADER_SLASH = "/";

    public static final String REQUEST_PATH_USER = "user";

    public static final String REQUEST_PATH_PERSON = "person";

    public static final String REQUEST_PATH_EXCEL = "excel";

    /**
     * 请求完整路径头
     */
    public static final String REQUEST_HEADER_USER = REQUEST_HEADER_SLASH + REQUEST_PATH_USER;

    public static final String REQUEST_HEADER_PERSON = REQUEST_HEADER_SLASH + REQUEST_PATH_PERSON;

    /**
     * 表格请求
     */
    public static final String REQUEST_HEADER_EXCEL = REQUEST_HEADER_SLASH + REQUEST_PATH_EXCEL;
}

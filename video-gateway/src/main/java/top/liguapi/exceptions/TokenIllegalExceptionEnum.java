package top.liguapi.exceptions;

/**
 * @Description
 * @Author lww
 * @Date 2022/5/16 21:31
 */
public enum TokenIllegalExceptionEnum {
    TOKEN_IS_EMPTY("令牌为空"),
    TOKEN_IS_ILLEGAL("令牌不合法");

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    TokenIllegalExceptionEnum(String message) {
        this.message = message;
    }
}

package top.liguapi.admin.exception;

/**
 * @Description
 * @Author lww
 * @Date 2022/5/16 17:40
 */
public enum AdminsExceptionEnum {
    USERNAME_ERROR("400", "用户名错误"),
    PASSWORD_ERROR("400", "密码错误");

    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    AdminsExceptionEnum(String status, String message) {
        this.status = status;
        this.message = message;
    }
}

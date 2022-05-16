package top.liguapi.admin.exception;

/**
 * @Description
 * @Author lww
 * @Date 2022/5/16 17:37
 */
public class AdminsException extends ControllerException {
    public AdminsException(AdminsExceptionEnum adminsExceptionEnum) {
        super(adminsExceptionEnum.getStatus(), adminsExceptionEnum.getMessage());
    }
}

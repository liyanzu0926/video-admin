package top.liguapi.exceptions;

//自定义异常
public class TokenIllegalException extends RuntimeException {

    public TokenIllegalException(TokenIllegalExceptionEnum tokenIllegalExceptionEnum) {
        super(tokenIllegalExceptionEnum.getMessage());
    }
}

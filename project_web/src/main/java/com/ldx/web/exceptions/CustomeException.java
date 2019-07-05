package com.ldx.web.exceptions;

//用户数据异常
public class CustomeException extends Exception{
    private String message;
//

    public CustomeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

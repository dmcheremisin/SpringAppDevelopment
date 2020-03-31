package com.learn.spring.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericException extends RuntimeException {

    private String exceptionMsg;
    private String exceptionCode;

    public GenericException(String exceptionCode, String
            exceptionMsg) {
        this.exceptionCode = exceptionCode;
        this.exceptionMsg = exceptionMsg;
    }


}

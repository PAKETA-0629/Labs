package com.ycloud.exception;


import com.ycloud.util.enums.error.ErrorType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ValidationException extends RuntimeException{
    private ErrorType errorType;
    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }

    public ErrorType getErrorType() {
        return ErrorType.FATAL_ERROR_TYPE;
    }


}

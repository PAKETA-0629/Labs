package com.ycloud.exception.order;


import com.ycloud.exception.ValidationException;
import com.ycloud.util.enums.error.ErrorType;

public class OrderIncorrectArgumentsException extends ValidationException {
    public static final String DEFAULT_MESSAGE = "Order is incorrect";
    public OrderIncorrectArgumentsException() {
        super(DEFAULT_MESSAGE);
    }

    public OrderIncorrectArgumentsException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }

}

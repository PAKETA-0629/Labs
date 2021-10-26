package com.ycloud.exception.order;


import com.ycloud.exception.ServiceException;
import com.ycloud.util.enums.error.ErrorType;

public class OrderNotFoundException extends ServiceException {
    public static final String DEFAULT_MESSAGE = "Order is not found";
    public OrderNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public OrderNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}

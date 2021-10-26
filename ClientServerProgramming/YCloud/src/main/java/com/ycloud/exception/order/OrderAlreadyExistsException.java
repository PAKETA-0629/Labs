package com.ycloud.exception.order;


import com.ycloud.exception.ServiceException;
import com.ycloud.util.enums.error.ErrorType;

public class OrderAlreadyExistsException extends ServiceException {
    public static final String DEFAULT_MESSAGE = "Such Order already exists";
    public OrderAlreadyExistsException() {
        super(DEFAULT_MESSAGE);
    }

    public OrderAlreadyExistsException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}

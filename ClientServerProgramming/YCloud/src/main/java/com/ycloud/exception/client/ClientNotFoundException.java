package com.ycloud.exception.client;


import com.ycloud.exception.ServiceException;
import com.ycloud.util.enums.error.ErrorType;

public class ClientNotFoundException extends ServiceException {
    public static final String DEFAULT_MESSAGE = "Client is not found";
    public ClientNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public ClientNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}

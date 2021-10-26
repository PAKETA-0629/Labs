package com.ycloud.exception.client;


import com.ycloud.exception.ServiceException;
import com.ycloud.util.enums.error.ErrorType;

public class ClientAlreadyExistsException extends ServiceException {
    public static final String DEFAULT_MESSAGE = "Such Client already exists";
    public ClientAlreadyExistsException() {
        super(DEFAULT_MESSAGE);
    }

    public ClientAlreadyExistsException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}

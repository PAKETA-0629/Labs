package com.ycloud.exception.master;


import com.ycloud.exception.ServiceException;
import com.ycloud.util.enums.error.ErrorType;

public class MasterAlreadyExistsException extends ServiceException {
    public static final String DEFAULT_MESSAGE = "Such Master already exists";
    public MasterAlreadyExistsException() {
        super(DEFAULT_MESSAGE);
    }

    public MasterAlreadyExistsException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}

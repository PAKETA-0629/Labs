package com.ycloud.exception.master;


import com.ycloud.exception.ServiceException;
import com.ycloud.util.enums.error.ErrorType;

public class MasterNotFoundException extends ServiceException {
    public static final String DEFAULT_MESSAGE = "Master is not found";
    public MasterNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public MasterNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}

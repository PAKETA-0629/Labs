package com.ycloud.exception.treatment;


import com.ycloud.exception.ServiceException;
import com.ycloud.util.enums.error.ErrorType;

public class TreatmentAlreadyExistsException extends ServiceException {
    public static final String DEFAULT_MESSAGE = "Such Treatment already exists";
    public TreatmentAlreadyExistsException() {
        super(DEFAULT_MESSAGE);
    }

    public TreatmentAlreadyExistsException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}

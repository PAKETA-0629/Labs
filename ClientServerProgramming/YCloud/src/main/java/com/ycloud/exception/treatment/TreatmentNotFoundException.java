package com.ycloud.exception.treatment;


import com.ycloud.exception.ServiceException;
import com.ycloud.util.enums.error.ErrorType;

public class TreatmentNotFoundException extends ServiceException {
    public static final String DEFAULT_MESSAGE = "Treatment is not found";
    public TreatmentNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public TreatmentNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}

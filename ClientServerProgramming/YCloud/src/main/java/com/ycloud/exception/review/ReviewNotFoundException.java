package com.ycloud.exception.review;


import com.ycloud.exception.ServiceException;
import com.ycloud.util.enums.error.ErrorType;

public class ReviewNotFoundException extends ServiceException {
    public static final String DEFAULT_MESSAGE = "Review is not found";
    public ReviewNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public ReviewNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}

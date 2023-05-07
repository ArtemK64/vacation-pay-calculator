package ru.vacationpay.services.exceptions;

public class IncorrectInputUserInformationException extends Exception {
    public IncorrectInputUserInformationException() {
    }

    public IncorrectInputUserInformationException(String message) {
        super(message);
    }

    public IncorrectInputUserInformationException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectInputUserInformationException(Throwable cause) {
        super(cause);
    }

    public IncorrectInputUserInformationException(
            String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package no.unit.alma;

import no.unit.alma.commons.HttpStatusException;

import javax.ws.rs.client.ResponseProcessingException;

public class AlmaErrorMessageHandler {

    public static String getAlmaErrorMessage(ResponseProcessingException exception) {
        if (exception.getCause() instanceof HttpStatusException) {
            HttpStatusException httpStatusException = (HttpStatusException) exception.getCause();
            final String errorCode = httpStatusException.getAlmaErrorCode();
            final String errorMessage = httpStatusException.getAlmaErrorMessage();
            final String errorTrackingId = httpStatusException.getAlmaErrorTrackingId();
            return errorCode + ": " + errorMessage + " (" + errorTrackingId + ")";
        } else {
            return exception.getMessage();
        }
    }

    public static String getAlmaErrorMessage(ResponseProcessingException exception, String target) {
        if (exception.getCause() instanceof HttpStatusException) {
            HttpStatusException httpStatusException = (HttpStatusException) exception.getCause();
            final String errorCode = httpStatusException.getAlmaErrorCode();
            final String errorMessage = httpStatusException.getAlmaErrorMessage();
            final String errorTrackingId = httpStatusException.getAlmaErrorTrackingId();
            return errorCode + ": " + errorMessage + " (" + errorTrackingId + ") / target : " + target;
        } else {
            return exception.getMessage();
        }
    }

    public static String getAlmaErrorCode(ResponseProcessingException exception) {
        if (exception.getCause() instanceof HttpStatusException) {
            HttpStatusException httpStatusException = (HttpStatusException) exception.getCause();
            return httpStatusException.getAlmaErrorCode();
        } else {
            return exception.getMessage();
        }
    }
}

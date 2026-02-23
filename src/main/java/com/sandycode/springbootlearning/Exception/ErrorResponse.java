package com.sandycode.springbootlearning.Exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorResponse {
    private final String message;
    private final int status;
    private final LocalDateTime timestamp;
    private Map<String, String> errorDetails;

    ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    ErrorResponse(String message, int status, Map<String, String> errorDetails) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now();
        this.errorDetails = errorDetails;
    }

    public Map<String, String> getErrorDetails() {
        return errorDetails;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

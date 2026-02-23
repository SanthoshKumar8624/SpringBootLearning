package com.sandycode.springbootlearning.Exception;

public class PasswordMismatchException extends RuntimeException {

    public PasswordMismatchException() {
        super("Password and Confirm Password didn't match");
    }
}
package org.example.exeptions;

import java.util.InputMismatchException;

public class TriangleException extends InputMismatchException {

    private static final String MESSAGE = "It is impossible to create triangle";

    public TriangleException(String e) {
        super(MESSAGE + e);
    }
}


package org.example.exeptions;

public class TriangleNotExistsException extends TriangleException {
    private static final String MESSAGE = " on a plane, at least in this universe";

    public TriangleNotExistsException() {
        super(MESSAGE);
    }
}

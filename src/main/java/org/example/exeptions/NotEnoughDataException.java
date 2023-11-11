package org.example.exeptions;

public class NotEnoughDataException extends TriangleException {
    private static final String MESSAGE = ": not enough data";

    public NotEnoughDataException() {
        super(MESSAGE);
    }
}

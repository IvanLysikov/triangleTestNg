package org.example.exeptions;

public class OutOfRangeException extends TriangleException {
    private static final String MESSAGE = ": data is out of range [1:2147483647]";

    public OutOfRangeException() {
        super(MESSAGE);
    }
}

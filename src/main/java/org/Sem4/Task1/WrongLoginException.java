package org.Sem4.Task1;

public class WrongLoginException extends RuntimeException {
    public WrongLoginException() {
        this("Wrong Login", 20);
    }

    public WrongLoginException(String message) {
        super(message);
    }

    public WrongLoginException(String excepted, int current) {
        super(String.format("excepted: %s, current chars: %d", excepted, current));
    }
}

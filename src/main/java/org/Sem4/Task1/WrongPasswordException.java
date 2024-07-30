package org.Sem4.Task1;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException() {
        this("Wrong Password", 20);
    }

    public WrongPasswordException(String message) {
        super(message);
    }

    public WrongPasswordException(String excepted, int current) {
        super(String.format("excepted: %s, current chars: %d", excepted, current));
    }
}

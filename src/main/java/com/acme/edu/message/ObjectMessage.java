package com.acme.edu.message;

public final class ObjectMessage extends Message {
    private static final String PREFIX = "reference";

    public ObjectMessage(Object value) {
        super(value, PREFIX);
    }
}

package com.acme.edu.message;

public final class BooleanMessage extends Message {
    private static final String PREFIX = "primitive";

    public BooleanMessage(Boolean value) {
        super(value, PREFIX);
    }
}

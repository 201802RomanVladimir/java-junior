package com.acme.edu.message;

public final class CharMessage extends Message {
    private static final String PREFIX = "char";

    public CharMessage(char value) {
        super(value, PREFIX);
    }
}

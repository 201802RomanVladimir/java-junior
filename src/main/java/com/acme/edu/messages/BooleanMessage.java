package com.acme.edu.messages;

public final class BooleanMessage extends Message {
    public BooleanMessage(Boolean value) {
        super(value, MessagePrefix.PRIMITIVE);
    }
}

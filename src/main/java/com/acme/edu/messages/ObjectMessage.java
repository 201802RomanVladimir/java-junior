package com.acme.edu.messages;

public final class ObjectMessage extends Message {
    public ObjectMessage(Object value) {
        super(value, MessagePrefix.REFERENCE);
    }
}

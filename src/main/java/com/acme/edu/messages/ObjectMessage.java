package com.acme.edu.messages;

public class ObjectMessage extends Message {
    public ObjectMessage(Object value) {
        super(value, MessagePrefix.REFERENCE);
    }
}

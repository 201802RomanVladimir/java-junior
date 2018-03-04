package com.acme.edu.messages;

public final class CharMessage extends Message {
    public CharMessage(char value) {
        super(value, MessagePrefix.CHAR);
    }
}

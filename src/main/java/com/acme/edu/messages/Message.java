package com.acme.edu.messages;

public abstract class Message {
    private static final String MESSAGE_TEMPLATE = "%s: %s";

    private Object value;
    private MessagePrefix prefix;

    public Message(Object value, MessagePrefix prefix) {
        this.value = value;
        this.prefix = prefix;
    }

    public Object getValue() {
        return value;
    }

    public boolean isAccumulationEnabled() {
        return false;
    }

    public boolean isNeedAccumulationReset() {
        return false;
    }

    public void doAccumulationAction() {}

    public void resetAccumulationState() {}

    protected String getMessageString() {
        return getValue().toString();
    }

    @Override
    public String toString() {
        return String.format(MESSAGE_TEMPLATE, prefix.getName(), getMessageString());
    }
}

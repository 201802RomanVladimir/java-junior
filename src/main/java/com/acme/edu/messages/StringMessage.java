package com.acme.edu.messages;

public class StringMessage extends Message {
    private static String previousString;
    private static int repeatCount;

    public StringMessage(String value) {
        super(value, MessagePrefix.STRING);
    }

    @Override
    protected String getMessageString() {
        return repeatCount > 1 ? String.format("%s (x%d)", getValue(), repeatCount) : getValue().toString();
    }

    @Override
    public boolean isAccumulationEnabled() {
        return true;
    }

    @Override
    public boolean isNeedAccumulationReset() {
        return previousString != null && !getValue().equals(previousString);
    }

    @Override
    public void doAccumulationAction() {
        previousString = getValue().toString();
        repeatCount++;
    }

    @Override
    public void resetAccumulationState() {
        previousString = null;
        repeatCount = 0;
    }
}

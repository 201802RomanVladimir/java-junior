package com.acme.edu.messages;

public class IntMessage extends Message {
    private static long sum;

    public IntMessage(int value) {
        super(value, MessagePrefix.PRIMITIVE);
    }

    @Override
    protected String getMessageString() {
        return String.valueOf(sum);
    }

    @Override
    public boolean isAccumulationEnabled() {
        return true;
    }

    @Override
    public boolean isNeedAccumulationReset() {
        return sum + (int)getValue() > Integer.MAX_VALUE;
    }

    @Override
    public void doAccumulationAction() {
        sum += (int)getValue();
    }

    @Override
    public void resetAccumulationState() {
        sum = 0;
    }
}

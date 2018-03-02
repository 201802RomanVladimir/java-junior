package com.acme.edu.messages;

public class ByteMessage extends Message {
    private static long sum;

    public ByteMessage(byte value) {
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
        return sum + (byte)getValue() > Byte.MAX_VALUE;
    }

    @Override
    public void doAccumulationAction() {
        sum += (byte)getValue();
    }

    @Override
    public void resetAccumulationState() {
        sum = 0;
    }
}

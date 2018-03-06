package com.acme.edu.message;

import com.acme.edu.accumulator.ByteSumAccumulator;

public final class ByteMessage extends Message {
    private static final String PREFIX = "primitive";

    public ByteMessage(byte value) {
        super(value, PREFIX, new ByteSumAccumulator(value));
    }

    @Override
    protected String getFormattedValue() {
        return String.valueOf(getAccumulator().getAccumulationValue());
    }
}
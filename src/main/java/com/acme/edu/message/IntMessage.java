package com.acme.edu.message;

import com.acme.edu.accumulator.IntSumAccumulator;

public final class IntMessage extends Message {
    private static final String PREFIX = "primitive";

    public IntMessage(int value) {
        super(value, PREFIX, new IntSumAccumulator(value));
    }

    @Override
    protected String getFormattedValue() {
        return String.valueOf(getAccumulator().getAccumulationValue());
    }
}

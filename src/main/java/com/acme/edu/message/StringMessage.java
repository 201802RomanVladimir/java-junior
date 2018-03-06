package com.acme.edu.message;

import com.acme.edu.accumulator.StringRepeatCounterAccumulator;

public final class StringMessage extends Message {
    private static final String PREFIX = "string";

    public StringMessage(String value) {
        super(value, PREFIX, new StringRepeatCounterAccumulator(value));
    }

    @Override
    protected String getFormattedValue() {
        long accValue = getAccumulator().getAccumulationValue();
        return accValue > 1 ? String.format("%s (x%d)", getValue(), accValue) : getValue().toString();
    }
}

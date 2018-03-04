package com.acme.edu.messages;

import com.acme.edu.accumulators.RepeatCounterAccumulatorImpl;

public final class StringMessage extends Message {
    public StringMessage(String value) {
        super(value, MessagePrefix.STRING, new RepeatCounterAccumulatorImpl());
    }

    @Override
    protected String getFormattedValue() {
        long accValue = getAccumulator().getAccumulationValue();
        return accValue > 1 ? String.format("%s (x%d)", getValue(), accValue) : getValue().toString();
    }
}

package com.acme.edu.messages;

import com.acme.edu.accumulators.SumAccumulatorImpl;

public final class IntMessage extends Message {
    public IntMessage(int value) {
        super(value, MessagePrefix.PRIMITIVE, new SumAccumulatorImpl(Integer.MAX_VALUE));
    }

    @Override
    protected String getFormattedValue() {
        return String.valueOf(getAccumulator().getAccumulationValue());
    }
}

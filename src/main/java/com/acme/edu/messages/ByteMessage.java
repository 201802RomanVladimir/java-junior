package com.acme.edu.messages;

import com.acme.edu.accumulators.SumAccumulatorImpl;

public class ByteMessage extends Message {
    public ByteMessage(byte value) {
        super(value, MessagePrefix.PRIMITIVE, new SumAccumulatorImpl(Byte.MAX_VALUE));
    }

    @Override
    protected String getFormattedValue() {
        return String.valueOf(getAccumulator().getAccumulationValue());
    }
}
package com.acme.edu.message;

import com.acme.edu.accumulator.ByteSumAccumulator;
import com.acme.edu.formatter.FormatVisitor;

public final class ByteMessage extends Message {
    public ByteMessage(byte value) {
        super(value, new ByteSumAccumulator(value));
    }

    @Override
    public String accept(FormatVisitor formatVisitor) {
        return formatVisitor.formatByte(this);
    }

    @Override
    public String toString() {
        return String.valueOf(getAccumulator().getAccumulationValue());
    }
}
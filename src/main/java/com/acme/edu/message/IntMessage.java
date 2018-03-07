package com.acme.edu.message;

import com.acme.edu.accumulator.IntSumAccumulator;
import com.acme.edu.formatter.FormatVisitor;

public final class IntMessage extends Message {
    public IntMessage(int value) {
        super(value, new IntSumAccumulator(value));
    }

    @Override
    public String accept(FormatVisitor formatVisitor) {
        return formatVisitor.formatInt(this);
    }

    @Override
    public String toString() {
        return String.valueOf(getAccumulator().getAccumulationValue());
    }
}

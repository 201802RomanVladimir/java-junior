package com.acme.edu.message;

import com.acme.edu.accumulator.StringRepeatCounterAccumulator;
import com.acme.edu.formatter.FormatVisitor;

public final class StringMessage extends Message {
    public StringMessage(String value) {
        super(value, new StringRepeatCounterAccumulator(value));
    }

    @Override
    public String accept(FormatVisitor formatVisitor) {
        return formatVisitor.formatString(this);
    }

    @Override
    public String toString() {
        long accValue = getAccumulator().getAccumulationValue();
        return accValue > 1 ? String.format("%s (x%d)", getValue(), accValue) : getValue().toString();
    }
}

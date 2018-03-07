package com.acme.edu.message;

import com.acme.edu.formatter.FormatVisitor;

public final class BooleanMessage extends Message {
    public BooleanMessage(Boolean value) {
        super(value);
    }

    @Override
    public String accept(FormatVisitor formatVisitor) {
        return formatVisitor.formatBoolean(this);
    }
}

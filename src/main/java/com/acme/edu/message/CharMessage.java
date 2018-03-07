package com.acme.edu.message;

import com.acme.edu.formatter.FormatVisitor;

public final class CharMessage extends Message {
    public CharMessage(Object value) {
        super(value);
    }

    @Override
    public String accept(FormatVisitor formatVisitor) {
        return formatVisitor.formatChar(this);
    }
}

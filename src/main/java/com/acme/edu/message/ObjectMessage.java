package com.acme.edu.message;

import com.acme.edu.formatter.FormatVisitor;

public final class ObjectMessage extends Message {
    public ObjectMessage(Object value) {
        super(value);
    }

    @Override
    public String accept(FormatVisitor formatVisitor) {
        return formatVisitor.formatObject(this);
    }
}

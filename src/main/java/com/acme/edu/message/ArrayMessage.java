package com.acme.edu.message;

import com.acme.edu.formatter.FormatVisitor;
import com.acme.edu.helper.ArrayHelper;

public final class ArrayMessage extends Message {
    public ArrayMessage(int[] value) {
        super(value);
    }

    @Override
    public String accept(FormatVisitor formatVisitor) {
        return formatVisitor.formatArray(this);
    }

    @Override
    public String toString() {
        return ArrayHelper.intArrayToString((int[])getValue());
    }
}
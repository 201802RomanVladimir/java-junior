package com.acme.edu.message;

import com.acme.edu.helper.ArrayHelper;

public final class ArrayMessage extends Message {
    private static final String PREFIX = "primitives array";

    public ArrayMessage(int[] value) {
        super(value, PREFIX);
    }

    protected String getFormattedValue() {
        return ArrayHelper.intArrayToString((int[])getValue());
    }
}
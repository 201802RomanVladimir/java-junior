package com.acme.edu.messages;

import com.acme.edu.helpers.ArrayHelper;

public final class ArrayMessage extends Message {
    public ArrayMessage(int[] value) {
        super(value, MessagePrefix.ARRAY);
    }

    protected String getFormattedValue() {
        return ArrayHelper.intArrayToString((int[])getValue());
    }
}
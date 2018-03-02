package com.acme.edu.messages;

import com.acme.edu.helpers.ArrayHelper;

public class ArrayMessage extends Message {
    public ArrayMessage(int[] value) {
        super(value, MessagePrefix.ARRAY);
    }

    protected String getMessageString() {
        return ArrayHelper.arrayToString((int[])getValue());
    }
}
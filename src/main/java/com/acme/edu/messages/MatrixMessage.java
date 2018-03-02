package com.acme.edu.messages;

import com.acme.edu.helpers.ArrayHelper;

public class MatrixMessage extends Message {
    public MatrixMessage(int[][] value) {
        super(value, MessagePrefix.MATRIX);
    }

    @Override
    protected String getMessageString() {
        return ArrayHelper.matrixToString((int[][])getValue());
    }
}
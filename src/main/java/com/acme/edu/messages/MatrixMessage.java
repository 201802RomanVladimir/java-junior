package com.acme.edu.messages;

import com.acme.edu.helpers.ArrayHelper;

public final class MatrixMessage extends Message {
    public MatrixMessage(int[][] value) {
        super(value, MessagePrefix.MATRIX);
    }

    @Override
    protected String getFormattedValue() {
        return ArrayHelper.intMatrixToString((int[][])getValue());
    }
}
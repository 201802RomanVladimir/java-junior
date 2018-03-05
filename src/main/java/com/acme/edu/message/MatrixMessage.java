package com.acme.edu.message;

import com.acme.edu.helper.ArrayHelper;

public final class MatrixMessage extends Message {
    private static final String PREFIX = "primitives matrix";

    public MatrixMessage(int[][] value) {
        super(value, PREFIX);
    }

    @Override
    protected String getFormattedValue() {
        return ArrayHelper.intMatrixToString((int[][])getValue());
    }
}
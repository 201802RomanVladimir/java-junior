package com.acme.edu.message;

import com.acme.edu.formatter.FormatVisitor;
import com.acme.edu.helper.ArrayHelper;

public final class MatrixMessage extends Message {
    public MatrixMessage(int[][] value) {
        super(value);
    }

    @Override
    public String accept(FormatVisitor formatVisitor) {
        return formatVisitor.formatMatrix(this);
    }

    @Override
    public String toString() {
        return ArrayHelper.intMatrixToString((int[][])getValue());
    }
}
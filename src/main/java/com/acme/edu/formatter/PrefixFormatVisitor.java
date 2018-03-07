package com.acme.edu.formatter;

import com.acme.edu.message.*;

/**
 * Форматтер разных типов сообщений с поддержкой prefix.
 */
public class PrefixFormatVisitor implements FormatVisitor {
    private static final String CHAR_PREFIX = "char";
    private static final String STRING_PREFIX = "string";
    private static final String REFERENCE_PREFIX = "reference";
    private static final String PRIMITIVE_PREFIX = "primitive";
    private static final String PRIMITIVE_ARRAY_PREFIX = "primitives array";
    private static final String PRIMITIVE_MATRIX_PREFIX = "primitives matrix";

    private static final String MESSAGE_TEMPLATE = "%s: %s";

    @Override
    public String formatObject(ObjectMessage objectMessage) {
        return getFormattedValue(REFERENCE_PREFIX, objectMessage);
    }

    @Override
    public String formatInt(IntMessage intMessage) {
        return getFormattedValue(PRIMITIVE_PREFIX, intMessage);
    }

    @Override
    public String formatChar(CharMessage charMessage) {
        return getFormattedValue(CHAR_PREFIX, charMessage);
    }

    @Override
    public String formatString(StringMessage stringMessage) {
        return getFormattedValue(STRING_PREFIX, stringMessage);
    }

    @Override
    public String formatByte(ByteMessage byteMessage) {
        return getFormattedValue(PRIMITIVE_PREFIX, byteMessage);
    }

    @Override
    public String formatBoolean(BooleanMessage booleanMessage) {
        return getFormattedValue(PRIMITIVE_PREFIX, booleanMessage);
    }

    @Override
    public String formatArray(ArrayMessage arrayMessage) {
        return getFormattedValue(PRIMITIVE_ARRAY_PREFIX, arrayMessage);
    }

    @Override
    public String formatMatrix(MatrixMessage matrixMessage) {
        return getFormattedValue(PRIMITIVE_MATRIX_PREFIX, matrixMessage);
    }

    private static String getFormattedValue(String prefix, Object message) {
        return String.format(MESSAGE_TEMPLATE, prefix, message);
    }
}

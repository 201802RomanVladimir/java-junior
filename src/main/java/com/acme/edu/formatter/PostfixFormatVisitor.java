package com.acme.edu.formatter;

import com.acme.edu.message.*;

/**
 * Форматтер разных типов сообщений с поддержкой postfix.
 */
public class PostfixFormatVisitor implements FormatVisitor {
    private static final String CHAR_POSTFIX = "char";
    private static final String STRING_POSTFIX = "string";
    private static final String REFERENCE_POSTFIX = "reference";
    private static final String PRIMITIVE_POSTFIX = "primitive";
    private static final String PRIMITIVE_ARRAY_POSTFIX = "primitives array";
    private static final String PRIMITIVE_MATRIX_POSTFIX = "primitives matrix";

    private static final String MESSAGE_TEMPLATE = "%s %s";

    @Override
    public String formatObject(ObjectMessage objectMessage) {
        return getFormattedValue(REFERENCE_POSTFIX, objectMessage);
    }

    @Override
    public String formatInt(IntMessage intMessage) {
        return getFormattedValue(PRIMITIVE_POSTFIX, intMessage);
    }

    @Override
    public String formatChar(CharMessage charMessage) {
        return getFormattedValue(CHAR_POSTFIX, charMessage);
    }

    @Override
    public String formatString(StringMessage stringMessage) {
        return getFormattedValue(STRING_POSTFIX, stringMessage);
    }

    @Override
    public String formatByte(ByteMessage byteMessage) {
        return getFormattedValue(PRIMITIVE_POSTFIX, byteMessage);
    }

    @Override
    public String formatBoolean(BooleanMessage booleanMessage) {
        return getFormattedValue(PRIMITIVE_POSTFIX, booleanMessage);
    }

    @Override
    public String formatArray(ArrayMessage arrayMessage) {
        return getFormattedValue(PRIMITIVE_ARRAY_POSTFIX, arrayMessage);
    }

    @Override
    public String formatMatrix(MatrixMessage matrixMessage) {
        return getFormattedValue(PRIMITIVE_MATRIX_POSTFIX, matrixMessage);
    }

    private static String getFormattedValue(String postfix, Object message) {
        return String.format(MESSAGE_TEMPLATE, message, postfix);
    }
}

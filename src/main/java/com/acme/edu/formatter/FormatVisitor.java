package com.acme.edu.formatter;

import com.acme.edu.message.*;

/**
 * Интерфейс форматеров.
 * Предназначен для реализации формата данных.
 */
public interface FormatVisitor {
    String formatObject(ObjectMessage objectMessage);

    String formatMatrix(MatrixMessage matrixMessage);

    String formatInt(IntMessage intMessage);

    String formatChar(CharMessage charMessage);

    String formatString(StringMessage stringMessage);

    String formatByte(ByteMessage byteMessage);

    String formatBoolean(BooleanMessage booleanMessage);

    String formatArray(ArrayMessage arrayMessage);

    default String format(Message message) {
        return message.accept(this);
    }
}

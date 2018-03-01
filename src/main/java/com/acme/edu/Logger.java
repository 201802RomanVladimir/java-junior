package com.acme.edu;

/**
 * Logs messages.
 * @author 201802RomanVladimir
 */
public class Logger {

    private static final String CHAR_PREFIX = "char";
    private static final String STRING_PREFIX = "string";
    private static final String REFERENCE_PREFIX = "reference";
    private static final String PRIMITIVE_PREFIX = "primitive";
    private static final String PRIMITIVE_ARRAY_PREFIX = "primitives array";
    private static final String PRIMITIVE_MATRIX_PREFIX = "primitives matrix";

    private static final String MESSAGE_TEMPLATE = "%s: %s%s";

    private static String resultBuffer = "";
    private static String previousTypeName;
    private static String previousString;
    private static int repeatCount;
    private static long sum;

    /**
     * Print int.
     * @param message The int to be printed.
     */
    public static void log(int message) {
        flushIfTypeChanged(message);
        flushIfMaxValueOverflow(message, Integer.MAX_VALUE);

        sum += message;
        resultBuffer = buildMessage(PRIMITIVE_PREFIX, sum);
    }

    /**
     * Print byte.
     * @param message byte to be printed.
     */
    public static void log(byte message) {
        flushIfTypeChanged(message);
        flushIfMaxValueOverflow(message, Byte.MAX_VALUE);

        sum += message;
        resultBuffer = buildMessage(PRIMITIVE_PREFIX, sum);
    }

    /**
     * Print boolean.
     * @param message The boolean to be printed.
     */
    public static void log(boolean message) {
        flushIfTypeChanged(message);
        resultBuffer += buildMessage(PRIMITIVE_PREFIX, message);
    }

    /**
     * Print char.
     * @param message The char to be printed.
     */
    public static void log(char message) {
        flushIfTypeChanged(message);
        resultBuffer += buildMessage(CHAR_PREFIX, message);
    }

    /**
     * Print String.
     * @param message The String to be printed.
     */
    public static void log(String message) {
        flushIfTypeChanged(message);
        flushIfStringEquals(message);

        previousString = message;
        repeatCount++;

        String formattedMessage = repeatCount > 1 ? String.format("%s (x%d)", message, repeatCount) : message;
        resultBuffer = buildMessage(STRING_PREFIX, formattedMessage);
    }

    /**
     * Print Object.
     * @param message The Object to be printed.
     */
    public static void log(Object message) {
        flushIfTypeChanged(message);
        resultBuffer += buildMessage(REFERENCE_PREFIX, message);
    }

    /**
     * Print array.
     * @param message The array to be printed.
     */
    public static void log(int[] message) {
        flushIfTypeChanged(message);
        resultBuffer += buildMessage(PRIMITIVE_ARRAY_PREFIX, arrayToString(message));
    }

    /**
     * Print matrix.
     * @param message The matrix to be printed.
     */
    public static void log(int[][] message) {
        flushIfTypeChanged(message);
        resultBuffer += buildMessage(PRIMITIVE_MATRIX_PREFIX, matrixToString(message));
    }

    /**
     * Flush and print message.
     */
    public static void flush() {
        printMessage();

        sum = 0;
        repeatCount = 0;
        resultBuffer = "";
    }

    //region Privates

    private static String arrayToString(int[] array) {
        StringBuilder resultSB = new StringBuilder("{");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                resultSB.append(", ");
            }
            resultSB.append(array[i]);
        }
        resultSB.append("}");

        return resultSB.toString();
    }

    private static String matrixToString(int[][] matrix) {
        StringBuilder resultSB = new StringBuilder("{");
        resultSB.append(System.lineSeparator());
        for (int i = 0; i < matrix.length; i++) {
            resultSB.append(arrayToString(matrix[i]));
            resultSB.append(System.lineSeparator());
        }
        resultSB.append("}");

        return resultSB.toString();
    }

    private static void flushIfTypeChanged(Object message) {
        String objectTypeName = message.getClass().getSimpleName();
        if (!objectTypeName.equals(previousTypeName)) {
            flush();
        }
        previousTypeName = objectTypeName;
    }

    private static void flushIfMaxValueOverflow(int message, int maxValue) {
        if (sum + message > maxValue) {
            flush();
        }
    }

    private static void flushIfStringEquals(String message) {
        if (previousString != null && !message.equals(previousString)) {
            flush();
        }
    }

    private static String buildMessage(String prefix, Object message) {
        return String.format(MESSAGE_TEMPLATE, prefix, message, System.lineSeparator());
    }

    private static void printMessage() {
        if (resultBuffer != null) {
            System.out.print(resultBuffer);
        }
    }

    //endregion
}

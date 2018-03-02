package com.acme.edu;

import com.acme.edu.messages.*;

/**
 * Logs messages.
 * @author 201802RomanVladimir
 */
public class Logger {
    private static LoggerController loggerController = new LoggerController();

    /**
     * Print int.
     * @param message The int to be printed.
     */
    public static void log(int message) {
        loggerController.log(new IntMessage(message));
    }

    /**
     * Print byte.
     * @param message byte to be printed.
     */
    public static void log(byte message) {
        loggerController.log(new ByteMessage(message));
    }

    /**
     * Print boolean.
     * @param message The boolean to be printed.
     */
    public static void log(boolean message) {
        loggerController.log(new BooleanMessage(message));
    }

    /**
     * Print char.
     * @param message The char to be printed.
     */
    public static void log(char message) {
        loggerController.log(new CharMessage(message));
    }

    /**
     * Print String.
     * @param message The String to be printed.
     */
    public static void log(String message) {
        loggerController.log(new StringMessage(message));
    }

    /**
     * Print Object.
     * @param message The Object to be printed.
     */
    public static void log(Object message) {
        loggerController.log(new ObjectMessage(message));
    }

    /**
     * Print array.
     * @param message The array to be printed.
     */
    public static void log(int[] message) {
        loggerController.log(new ArrayMessage(message));
    }

    /**
     * Print matrix.
     * @param message The matrix to be printed.
     */
    public static void log(int[][] message) {
        loggerController.log(new MatrixMessage(message));
    }

    /**
     * Flush and print message.
     */
    public static void flush() {
        loggerController.flush();
    }
}

package com.acme.edu;

/**
 * Logs messages.
 * @author 201802RomanVladimir
 */
public class Logger {
    /**
     * Print int.
     * @param message The int to be printed.
     */
    public static void log(int message) {
        printPrimitiveMessage(message);
    }

    /**
     * Print byte.
     * @param message byte to be printed.
     */
    public static void log(byte message) {
        printPrimitiveMessage(message);
    }

    /**
     * Print boolean.
     * @param message The boolean to be printed.
     */
    public static void log(boolean message) {
        printPrimitiveMessage(message);
    }

    /**
     * Print char.
     * @param message The char to be printed.
     */
    public static void log(char message) {
        printMessage("char",message);
    }

    /**
     * Print String.
     * @param message The String to be printed.
     */
    public static void log(String message) {
        printMessage("string", message);
    }

    /**
     * Print Object.
     * @param message The Object to be printed.
     */
    public static void log(Object message) {
        printMessage("reference", message);
    }

    //region Privates

    private static void printPrimitiveMessage(Object message) {
        printMessage("primitive", message);
    }

    private static void printMessage(String prefix, Object message) {
        System.out.println(String.format("%s: %s", prefix, message));
    }

    //endregion
}

package com.acme.edu;

import com.acme.edu.formatter.PrefixFormatVisitor;
import com.acme.edu.message.*;

/**
 * Логирование сообщений разного типа
 * @author 201802RomanVladimir
 */
public class Logger {
    private final static LoggerController loggerController = new LoggerController(
            System.out::println
    );

    /**
     * Логирование сообщения {@code message} типа {@code int}
     * @param message объект типа {@code int} для логирования
     */
    public static void log(int message) {
        loggerController.log(new IntMessage(message), new PrefixFormatVisitor());
    }

    /**
     * Логирование сообщения {@code message} типа {@code byte}
     * @param message объект типа {@code byte} для логирования
     */
    public static void log(byte message) {
        loggerController.log(new ByteMessage(message), new PrefixFormatVisitor());
    }

    /**
     * Логирование сообщения {@code message} типа {@code boolean}
     * @param message объект типа {@code boolean} для логирования
     */
    public static void log(boolean message) {
        loggerController.log(new BooleanMessage(message), new PrefixFormatVisitor());
    }

    /**
     * Логирование сообщения {@code message} типа {@code char}
     * @param message объект типа {@code char} для логирования
     */
    public static void log(char message) {
        loggerController.log(new CharMessage(message), new PrefixFormatVisitor());
    }

    /**
     * Логирование сообщения {@code message} типа {@link String}
     * @param message объект типа {@link String} для логирования
     */
    public static void log(String message) {
        loggerController.log(new StringMessage(message), new PrefixFormatVisitor());
    }

    /**
     * Логирование сообщения {@code message} типа {@link Object}
     * @param message объект типа {@link Object} для логирования
     */
    public static void log(Object message) {
        loggerController.log(new ObjectMessage(message), new PrefixFormatVisitor());
    }

    /**
     * Логирование сообщения {@code message} типа {@code int[]}
     * @param message объект типа {@code int[]} для логирования
     */
    public static void log(int[] message) {
        loggerController.log(new ArrayMessage(message), new PrefixFormatVisitor());
    }

    /**
     * Логирование сообщения {@code message} типа {@code int[][]}
     * @param message объект типа {@code int[][]} для логирования
     */
    public static void log(int[][] message) {
        loggerController.log(new MatrixMessage(message), new PrefixFormatVisitor());
    }

    /**
     * Вывод накопленных сообщений из буфера
     */
    public static void flush() {
        loggerController.flush();
    }
}

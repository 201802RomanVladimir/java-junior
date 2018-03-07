package com.acme.edu.saver;

/**
 * Вывод сообщения в консоль
 */
public final class ConsoleSaver implements Saver {
    /**
     * Выводит сообщение {@code message} в консоль
     * @param message сообщение
     */
    @Override
    public void save(String message) {
        System.out.println(message);
    }
}

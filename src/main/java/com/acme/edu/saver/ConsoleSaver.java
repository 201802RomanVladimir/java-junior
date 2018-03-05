package com.acme.edu.saver;

import com.acme.edu.message.Message;

/**
 * Вывод сообщения в консоль
 */
public final class ConsoleSaver implements Saver {
    /**
     * Выводит сообщение {@code message} в консоль
     * @param message сообщение
     */
    @Override
    public void save(Message message) {
        System.out.println(message);
    }
}

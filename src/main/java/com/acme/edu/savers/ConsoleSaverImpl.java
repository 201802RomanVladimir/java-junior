package com.acme.edu.savers;

import com.acme.edu.messages.Message;

/**
 * Вывод сообщения в консоль
 */
public final class ConsoleSaverImpl implements Saver {
    /**
     * Выводит сообщение {@code message} в консоль
     * @param message сообщение
     */
    @Override
    public void save(Message message) {
        System.out.println(message);
    }
}

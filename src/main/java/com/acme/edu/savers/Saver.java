package com.acme.edu.savers;

import com.acme.edu.messages.Message;

/**
 * Интерфейс для сохранеия сообщений
 */
public interface Saver {
    /**
     * Сохряет сообщение {@code message}
     * @param message сообщение
     */
    void save(Message message);
}

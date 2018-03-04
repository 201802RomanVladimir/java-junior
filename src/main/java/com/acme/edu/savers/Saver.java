package com.acme.edu.savers;

import com.acme.edu.messages.Message;

/**
 * Интерфейс для сохранеия сообщений
 */
public interface Saver {
    /**
     * Сохраняет сообщение {@code message}
     * @param message сообщение
     */
    void save(Message message);
}

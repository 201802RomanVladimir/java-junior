package com.acme.edu.saver;

import com.acme.edu.message.Message;

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

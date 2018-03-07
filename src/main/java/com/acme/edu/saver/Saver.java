package com.acme.edu.saver;

/**
 * Интерфейс для сохранеия сообщений
 */
public interface Saver {
    /**
     * Сохраняет сообщение {@code message}
     * @param message сообщение
     */
    void save(String message);
}

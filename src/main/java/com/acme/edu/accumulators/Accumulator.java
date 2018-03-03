package com.acme.edu.accumulators;

import com.acme.edu.messages.Message;

/**
 * Интерфейс аккумуляторов
 * Предназначен для реализации алгоритма накопления данных в логгере
 */
public interface Accumulator {
    /**
     * Проверяет достижение граничного значения при аккумулировании сообщения {@code message}
     * @param message сообщение для аккумуляции
     * @return {@code true} если граничное значение будет достигнуто, в противном случае {@code false}
     */
    boolean isNeedAccumulationReset(Message message);

    /**
     * Выполняет операцию аккумуляции сообщения {@code message}
     * @param message сообщение для аккумуляции
     */
    void doAccumulationAction(Message message);

    /**
     * Сбрасывает состояние аккумулятора к начальному состоянию
     */
    void resetAccumulationState();

    /**
     * Возвращает значение аккумулятора
     * @return {@code long} значение аккумулятора
     */
    long getAccumulationValue();
}
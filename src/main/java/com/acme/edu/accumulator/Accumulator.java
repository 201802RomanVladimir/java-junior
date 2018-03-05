package com.acme.edu.accumulator;

import com.acme.edu.message.Message;

/**
 * Интерфейс аккумуляторов
 * Предназначен для реализации алгоритма накопления данных в логгере
 */
public interface Accumulator<T> {
    /**
     * Проверяет достижение граничного значения при аккумулировании сообщения {@code message}
     * @param value значение для аккумуляции
     * @return {@code true} если граничное значение будет достигнуто, в противном случае {@code false}
     */
    boolean isNeedAccumulationReset(T value);

    /**
     * Выполняет операцию аккумуляции сообщения {@code message}
     * @param value значение для аккумуляции
     */
    void doAccumulationAction(T value);

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
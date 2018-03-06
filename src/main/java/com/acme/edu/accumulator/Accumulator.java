package com.acme.edu.accumulator;

/**
 * Интерфейс аккумуляторов.
 * Предназначен для реализации алгоритма накопления данных в логгере.
 */
public interface Accumulator {
    /**
     * Проверяет достижение граничного значения при аккумулировании значения.
     * @return {@code true} если граничное значение будет достигнуто, в противном случае {@code false}
     */
    boolean isNeedAccumulationReset();

    /**
     * Выполняет операцию аккумуляции значения.
     */
    void doAccumulationAction();

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
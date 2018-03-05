package com.acme.edu.accumulator;

import com.acme.edu.message.Message;

/**
 * Аккумулятор логгера с подсчётом повторяющихся значений
 */
public class RepeatCounterAccumulator<T> implements Accumulator<T> {
    private static String previousString;
    private static int repeatCount;

    /**
     * Сравнивает значение сообщения {@code message} с предыдущим значением сообщением того же типа
     * @param value значение для аккумуляции
     * @return {@code true} если текущее значение сообщения отличается от предыдущего, в противном случае {@code false}
     */
    @Override
    public boolean isNeedAccumulationReset(T value) {
        return previousString != null && !value.equals(previousString);
    }

    /**
     * Выполняет операцию аккумуляции сообщения {@code message}.
     * Также увеличивает счётчик повтора одинаковых значений сообщений
     * @param value значение для аккумуляции
     */
    @Override
    public void doAccumulationAction(T value) {
        previousString = value.toString();
        repeatCount++;
    }

    /**
     * Сбрасывает состояние аккумулятора к начальному состоянию
     */
    @Override
    public void resetAccumulationState() {
        previousString = null;
        repeatCount = 0;
    }

    /**
     * Возвращает значение аккумулятора
     * @return {@code long} значение аккумулятора
     */
    @Override
    public long getAccumulationValue() {
        return repeatCount;
    }
}

package com.acme.edu.accumulators;

import com.acme.edu.messages.Message;

/**
 * Аккумулятор логгера с подсчётом суммы
 */
public class SumAccumulatorImpl implements Accumulator {
    private static long sum;
    private int maxValue;

    public SumAccumulatorImpl(int maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * Проверяет выход за верхний предел расчитываемой суммы
     * @param message сообщение для аккумуляции
     * @return {@code true} если будет выход за верхний предел, в противном случае {@code false}
     */
    @Override
    public boolean isNeedAccumulationReset(Message message) {
        return sum + Integer.parseInt(String.valueOf(message.getValue())) > maxValue;
    }

    /**
     * Выполняет суммирование сообщения {@code message}
     * @param message сообщение для аккумуляции
     */
    @Override
    public void doAccumulationAction(Message message) {
        sum += Integer.parseInt(String.valueOf(message.getValue()));
    }

    /**
     * Сбрасывает состояние аккумулятора к начальному состоянию
     */
    @Override
    public void resetAccumulationState() {
        sum = 0;
    }

    /**
     * Возвращает значение аккумулятора
     * @return {@code long} значение аккумулятора
     */
    @Override
    public long getAccumulationValue() {
        return sum;
    }
}

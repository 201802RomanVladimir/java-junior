package com.acme.edu.accumulator;

import java.io.Serializable;

/**
 * Аккумулятор типа byte с подсчётом суммы.
 */
public class ByteSumAccumulator implements Accumulator, Serializable {
    private static long sum;

    private byte currentValue;

    public ByteSumAccumulator(byte currentValue) {
        this.currentValue = currentValue;
    }

    /**
     * Проверяет выход за верхний предел расчитываемой суммы.
     * @return {@code true} если будет выход за верхний предел, в противном случае {@code false}
     */
    @Override
    public boolean isNeedAccumulationReset() {
        return sum + currentValue > Byte.MAX_VALUE;
    }

    /**
     * Выполняет суммирование текущего значения.
     */
    @Override
    public void doAccumulationAction() {
        sum += currentValue;
    }

    /**
     * Сбрасывает состояние аккумулятора к начальному состоянию.
     */
    @Override
    public void resetAccumulationState() {
        sum = 0;
    }

    /**
     * Возвращает значение аккумулятора.
     * @return {@code long} значение аккумулятора
     */
    @Override
    public long getAccumulationValue() {
        return sum;
    }
}
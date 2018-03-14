package com.acme.edu.accumulator;

import java.io.Serializable;

/**
 * Аккумулятор типа int с подсчётом суммы.
 */
public class IntSumAccumulator implements Accumulator, Serializable {
    private static long sum;

    private int currentValue;

    public IntSumAccumulator(int currentValue) {
        this.currentValue = currentValue;
    }

    /**
     * Проверяет выход за верхний предел расчитываемой суммы.
     * @return {@code true} если будет выход за верхний предел, в противном случае {@code false}
     */
    @Override
    public boolean isNeedAccumulationReset() {
        return sum + currentValue > Integer.MAX_VALUE;
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
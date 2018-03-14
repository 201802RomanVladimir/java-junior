package com.acme.edu.accumulator;

import java.io.Serializable;

/**
 * Аккумулятор строк с подсчётом повторяющихся значений.
 */
public class StringRepeatCounterAccumulator implements Accumulator, Serializable {
    private static String previousValue;
    private static int repeatCount;

    private String currentValue;

    public StringRepeatCounterAccumulator(String currentValue) {
        this.currentValue = currentValue;
    }

    /**
     * Сравнивает текущее значение с предыдущим значением.
     * @return {@code true} если текущее значение отличается от предыдущего, в противном случае {@code false}
     */
    @Override
    public boolean isNeedAccumulationReset() {
        return previousValue != null && !currentValue.equals(previousValue);
    }

    /**
     * Выполняет операцию аккумуляции текущего значения.
     * Также увеличивает счётчик повтора одинаковых значений.
     */
    @Override
    public void doAccumulationAction() {
        previousValue = currentValue;
        repeatCount++;
    }

    /**
     * Сбрасывает состояние аккумулятора к начальному состоянию.
     */
    @Override
    public void resetAccumulationState() {
        previousValue = null;
        repeatCount = 0;
    }

    /**
     * Возвращает значение аккумулятора.
     * @return {@code long} значение аккумулятора
     */
    @Override
    public long getAccumulationValue() {
        return repeatCount;
    }
}

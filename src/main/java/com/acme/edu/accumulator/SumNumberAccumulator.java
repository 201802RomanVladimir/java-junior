package com.acme.edu.accumulator;

import com.acme.edu.message.Message;

/**
 * Аккумулятор логгера с подсчётом суммы
 */
public class SumNumberAccumulator<N extends Number> implements Accumulator<N> {
    private static long sum;
    private N maxValue;

    public SumNumberAccumulator(N maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * Проверяет выход за верхний предел расчитываемой суммы
     * @param value значение для аккумуляции
     * @return {@code true} если будет выход за верхний предел, в противном случае {@code false}
     */
    @Override
    public boolean isNeedAccumulationReset(N value) {
        return sum + value.longValue() > maxValue.longValue();
    }

    /**
     * Выполняет суммирование сообщения {@code message}
     * @param value значение для аккумуляции
     */
    @Override
    public void doAccumulationAction(N value) {
        sum += value.longValue();
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

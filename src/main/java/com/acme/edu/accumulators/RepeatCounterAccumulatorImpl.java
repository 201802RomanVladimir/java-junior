package com.acme.edu.accumulators;

import com.acme.edu.messages.Message;

/**
 * Аккумулятор логгера с подсчётом повторяющихся значений
 */
public class RepeatCounterAccumulatorImpl implements Accumulator {
    private static String previousString;
    private static int repeatCount;

    /**
     * Сравнивает значения соббщения {@code message} с предыдущим сообщением того же типа
     * @param message сообщение для аккумуляции
     * @return {@code true} если значение сообщения было изменено, в противном случае {@code false}
     */
    @Override
    public boolean isNeedAccumulationReset(Message message) {
        return previousString != null && !message.getValue().equals(previousString);
    }

    /**
     * Выполняет операцию аккумуляции сообщения {@code message}
     * Также увеличивает счётчик повтора одинаковых значений сообщений
     * @param message сообщение для аккумуляции
     */
    @Override
    public void doAccumulationAction(Message message) {
        previousString = message.getValue().toString();
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

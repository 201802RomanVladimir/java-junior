package com.acme.edu.message;

import com.acme.edu.accumulator.Accumulator;

/**
 * Абстрактный класс сообщения
 * Smart command
 */
public abstract class Message {
    private static final String MESSAGE_TEMPLATE = "%s: %s";

    private final Accumulator accumulator;
    private final Object value;
    private final String prefix;

    public Message(Object value, String prefix) {
        this(value, prefix, null);
    }

    public Message(Object value, String prefix, Accumulator accumulator) {
        this.value = value;
        this.prefix = prefix;
        this.accumulator = accumulator;
    }

    //region Accumulators

    /**
     * Возвращает аккумулятор, применяемый к текущенму типу сообщения.
     * Может вернуть null, если аккумулятор не задан
     * @return аккумулятор
     */
    Accumulator getAccumulator() {
        return accumulator;
    }

    /**
     * Есть ли в сообщении возможность аккумулирования
     * @return true, если возможность аккумулирования есть, иначе false
     */
    public boolean isAccumulationEnabled() {
        return getAccumulator() != null;
    }

    /**
     * Сообщает вызывающему классу о достижении граничного значения при аккумулировании.
     * При этом вызывающий класс может выполнить какие-то действия. Например, flush()
     * @return true, если граничное значение достигнуто, иначе false
     */
    public boolean isNeedAccumulationReset() {
        return isAccumulationEnabled() && accumulator.isNeedAccumulationReset(getValue());
    }

    /**
     * Выполнение действие текущего аккумулятора сообщения
     */
    public void doAccumulationAction() {
        if (isAccumulationEnabled()) {
            accumulator.doAccumulationAction(getValue());
        }
    }

    /**
     * Сброс текущего аккумулятора сообщения в начальное состояние
     */
    public void resetAccumulationState() {
        if (isAccumulationEnabled()) {
            accumulator.resetAccumulationState();
        }
    }

    //endregion Accumulators

    /**
     * Возвращает значение сообщения
     * @return значение сообщения
     */
    public Object getValue() {
        return value;
    }

    /**
     * Формирование значения строки сообщения
     * Надо переопределить при необходимости поведения, отличного от принятого по-умолчанию
     * @return форматированное значение
     */
    protected String getFormattedValue() {
        return getValue().toString();
    }

    /**
     * Возвращает форматированную строку сообщения
     * @return строка сообщения
     */
    @Override
    public String toString() {
        return String.format(MESSAGE_TEMPLATE, prefix, getFormattedValue());
    }
}

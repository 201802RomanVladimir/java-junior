package com.acme.edu.messages;

import com.acme.edu.accumulators.Accumulator;

/**
 * Абстрактный класс сообщения
 */
public abstract class Message {
    private static final String MESSAGE_TEMPLATE = "%s: %s";

    private Accumulator accumulator;
    private Object value;
    private MessagePrefix prefix;

    public Message(Object value, MessagePrefix prefix) {
        this(value, prefix, null);
    }

    public Message(Object value, MessagePrefix prefix, Accumulator accumulator) {
        this.value = value;
        this.prefix = prefix;
        this.accumulator = accumulator;
    }

    /**
     * Возвращает значение сообщения
     * @return значение сообщения
     */
    public Object getValue() {
        return value;
    }

    /**
     * Возвращает аккумулятор, применяемый к текущенму типу сообщения
     * Может вернуть null, если аккумулятор не задан
     * @return аккумулятор
     */
    Accumulator getAccumulator() {
        return accumulator;
    }

    /**
     * Есть ли в сообщении возможность аккумилирования
     * @return true, если возможность аккумилирования есть
     */
    public boolean isAccumulationEnabled() {
        return accumulator != null;
    }

    /**
     * Сообщает вызывающему классу о достижении граничного значения при аккумулировании
     * При этом вызывающий класс может выполнить какие-то действия. Например, flush()
     * @return true, если граничное значение достигнуто, иначе false
     */
    public boolean isNeedAccumulationReset() {
        return isAccumulationEnabled() && accumulator.isNeedAccumulationReset(this);
    }

    /**
     * Выполнение действие текущего аккумулятора сообщения
     */
    public void doAccumulationAction() {
        if (isAccumulationEnabled()) {
            accumulator.doAccumulationAction(this);
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
        return String.format(MESSAGE_TEMPLATE, prefix.getName(), getFormattedValue());
    }
}

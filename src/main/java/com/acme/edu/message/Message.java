package com.acme.edu.message;

import com.acme.edu.accumulator.Accumulator;
import com.acme.edu.formatter.FormatVisitor;

/**
 * Абстрактный класс сообщения
 * Smart command
 */
public abstract class Message {
    private static final String MESSAGE_TEMPLATE = "%s: %s";

    private final Accumulator accumulator;
    private final Object value;

    public Message(Object value) {
        this(value, null);
    }

    public Message(Object value, Accumulator accumulator) {
        this.value = value;
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
        return isAccumulationEnabled() && accumulator.isNeedAccumulationReset();
    }

    /**
     * Выполнение действие текущего аккумулятора сообщения
     */
    public void doAccumulationAction() {
        if (isAccumulationEnabled()) {
            accumulator.doAccumulationAction();
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
     * Возвращает форматированную строку сообщения
     * @return строка сообщения
     */
    @Override
    public String toString() {
        return getValue().toString();
    }

    /**
     * Вывывает метод визитора, который соответствует типу наследуемого сообщения.
     * Возвращает форматированную строку сообщения, которая зависит от типа сообщения.
     * @param formatVisitor визитор
     * @return форматированная строка
     */
    public abstract String accept(FormatVisitor formatVisitor);
}

package com.acme.edu.messages;

/**
 * Префиксы сообщения
 */
public enum MessagePrefix {
    PRIMITIVE("primitive"),
    CHAR("char"),
    STRING("string"),
    REFERENCE("reference"),
    ARRAY("primitives array"),
    MATRIX("primitives matrix");

    private final String name;

    MessagePrefix(String name) {
        this.name = name;
    }

    /**
     * Возвращает значение префикса.
     * @return значение префикса.
     */
    public String getName() {
        return name;
    }
}

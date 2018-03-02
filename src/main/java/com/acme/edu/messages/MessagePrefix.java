package com.acme.edu.messages;

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
     * Get name for enum item.
     * @return Return enum name.
     */
    public String getName() {
        return name;
    }
}

package org.jproperty.type;

public interface IntProperty extends ReadOnlyIntProperty, NumberProperty {

    @Override
    default void setValue(Number value) {
        set(value.intValue());
    }

    void set(int value);

}

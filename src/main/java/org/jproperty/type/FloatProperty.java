package org.jproperty.type;

public interface FloatProperty extends ReadOnlyFloatProperty, NumberProperty {

    @Override
    default void setValue(Number value) {
        set(value.floatValue());
    }

    void set(float value);

}

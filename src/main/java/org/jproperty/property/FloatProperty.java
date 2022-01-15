package org.jproperty.property;

import org.jproperty.value.ObservableFloatValue;

public interface FloatProperty extends ObservableFloatValue, NumberProperty {

    @Override
    default void setValue(Number value) {
        set(value.floatValue());
    }

    void set(float value);

}

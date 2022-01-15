package org.jproperty.property;

import org.jproperty.value.ObservableIntegerValue;

public interface IntProperty extends ObservableIntegerValue, NumberProperty {

    @Override
    default void setValue(Number value) {
        set(value.intValue());
    }

    void set(int value);

}

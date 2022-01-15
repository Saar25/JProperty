package org.jproperty.property;

import org.jproperty.value.ObservableIntegerValue;

public interface IntegerProperty extends ObservableIntegerValue, NumberProperty {

    @Override
    default void setValue(Number value) {
        set(value.intValue());
    }

    void set(int value);

}

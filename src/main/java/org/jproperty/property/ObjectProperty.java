package org.jproperty.property;

import org.jproperty.Property;
import org.jproperty.value.ObservableObjectValue;

public interface ObjectProperty<T> extends ObservableObjectValue<T>, Property<T> {

    @Override
    default void setValue(T value) {
        set(value);
    }

    void set(T value);

}

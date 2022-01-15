package org.jproperty.value;

import org.jproperty.ObservableValue;

public interface ObservableObjectValue<T> extends ObservableValue<T> {

    @Override
    default T getValue() {
        return get();
    }

    T get();
}

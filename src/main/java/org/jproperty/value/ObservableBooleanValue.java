package org.jproperty.value;

import org.jproperty.ObservableValue;

public interface ObservableBooleanValue extends ObservableValue<Boolean> {

    @Override
    default Boolean getValue() {
        return get();
    }

    boolean get();

}

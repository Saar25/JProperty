package org.jproperty.constant;

import org.jproperty.value.ObservableBooleanValue;

public class ConstantBooleanProperty extends ConstantPropertyBase<Boolean> implements ObservableBooleanValue {

    private final boolean value;

    public ConstantBooleanProperty(boolean value) {
        this.value = value;
    }

    @Override
    public boolean get() {
        return this.value;
    }

    @Override
    public String toString() {
        return "ConstantBooleanProperty{" + get() + '}';
    }
}

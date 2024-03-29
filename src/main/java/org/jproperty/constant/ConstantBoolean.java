package org.jproperty.constant;

import org.jproperty.value.ObservableBooleanValue;

public class ConstantBoolean extends ConstantValueBase<Boolean> implements ObservableBooleanValue {

    private final boolean value;

    public ConstantBoolean(boolean value) {
        this.value = value;
    }

    @Override
    public boolean get() {
        return this.value;
    }

    @Override
    public String toString() {
        return "ConstantBoolean{" + get() + '}';
    }
}

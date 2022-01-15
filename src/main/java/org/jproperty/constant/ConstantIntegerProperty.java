package org.jproperty.constant;

import org.jproperty.value.ObservableIntegerValue;

public class ConstantIntegerProperty extends ConstantPropertyBase<Number> implements ObservableIntegerValue {

    private final int value;

    public ConstantIntegerProperty(int value) {
        this.value = value;
    }

    @Override
    public int get() {
        return this.value;
    }

    @Override
    public String toString() {
        return "ConstantIntProperty{" + get() + '}';
    }
}

package org.jproperty.constant;

import org.jproperty.value.ObservableIntegerValue;

public class ConstantInteger extends ConstantValueBase<Number> implements ObservableIntegerValue {

    private final int value;

    public ConstantInteger(int value) {
        this.value = value;
    }

    @Override
    public int get() {
        return this.value;
    }

    @Override
    public String toString() {
        return "ConstantInteger{" + get() + '}';
    }
}

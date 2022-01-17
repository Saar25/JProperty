package org.jproperty.constant;

import org.jproperty.value.ObservableFloatValue;

public class ConstantFloat extends ConstantValueBase<Number> implements ObservableFloatValue {

    private final float value;

    public ConstantFloat(float value) {
        this.value = value;
    }

    @Override
    public float get() {
        return this.value;
    }

    @Override
    public String toString() {
        return "ConstantFloat{" + get() + '}';
    }
}

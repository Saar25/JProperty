package org.jproperty.constant;

import org.jproperty.value.ObservableFloatValue;

public class ConstantFloatProperty extends ConstantPropertyBase<Number> implements ObservableFloatValue {

    private final float value;

    public ConstantFloatProperty(float value) {
        this.value = value;
    }

    @Override
    public float get() {
        return this.value;
    }

    @Override
    public String toString() {
        return "ConstantFloatProperty{" + get() + '}';
    }
}

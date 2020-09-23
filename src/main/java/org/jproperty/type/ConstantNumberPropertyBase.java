package org.jproperty.type;

import org.jproperty.ReadOnlyProperty;

public abstract class ConstantNumberPropertyBase extends ConstantPropertyBase<Number> implements ReadOnlyProperty<Number> {

    public int getIntValue() {
        return getValue().intValue();
    }

    public float getFloatValue() {
        return getValue().floatValue();
    }

    public long getLongValue() {
        return getValue().longValue();
    }

    public double getDoubleValue() {
        return getValue().doubleValue();
    }
}

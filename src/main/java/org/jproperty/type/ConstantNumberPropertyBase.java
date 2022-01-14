package org.jproperty.type;

public abstract class ConstantNumberPropertyBase extends ConstantPropertyBase<Number> implements ReadOnlyNumberProperty {

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

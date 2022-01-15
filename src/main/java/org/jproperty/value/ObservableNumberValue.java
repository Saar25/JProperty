package org.jproperty.value;

import org.jproperty.ObservableValue;

public interface ObservableNumberValue extends ObservableValue<Number> {

    @Override
    Number getValue();

    default byte getByteValue() {
        return getValue().byteValue();
    }

    default int getIntValue() {
        return getValue().intValue();
    }

    default float getFloatValue() {
        return getValue().floatValue();
    }

    default long getLongValue() {
        return getValue().longValue();
    }

    default double getDoubleValue() {
        return getValue().doubleValue();
    }

}

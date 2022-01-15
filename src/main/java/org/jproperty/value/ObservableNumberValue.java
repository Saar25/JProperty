package org.jproperty.value;

import org.jproperty.ObservableValue;

public interface ObservableNumberValue extends ObservableValue<Number> {

    @Override
    Number getValue();

    byte getByteValue();

    int getIntValue();

    float getFloatValue();

    long getLongValue();

    double getDoubleValue();

}

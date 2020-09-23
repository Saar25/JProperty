package org.jproperty.type;

import org.jproperty.ReadOnlyProperty;

public interface ReadOnlyNumberProperty extends ReadOnlyProperty<Number> {

    @Override
    Number getValue();

    int getIntValue();

    long getLongValue();

    float getFloatValue();

    double getDoubleValue();

}

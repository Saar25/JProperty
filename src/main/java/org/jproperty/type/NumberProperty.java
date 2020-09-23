package org.jproperty.type;

import org.jproperty.Property;

public interface NumberProperty extends ReadOnlyNumberProperty, Property<Number> {

    @Override
    void setValue(Number value);

    void setValue(int value);

    void setValue(long value);

    void setValue(float value);

    void setValue(double value);


}

package org.jproperty.type;

import org.jproperty.Property;

public interface NumberProperty extends ReadOnlyNumberProperty, Property<Number> {

    @Override
    void setValue(Number value);

}

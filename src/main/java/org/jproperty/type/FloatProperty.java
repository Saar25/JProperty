package org.jproperty.type;

import org.jproperty.Property;

public interface FloatProperty extends ReadOnlyFloatProperty, Property<Number> {

    void set(float value);

}

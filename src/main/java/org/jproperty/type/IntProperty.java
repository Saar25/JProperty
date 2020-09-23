package org.jproperty.type;

import org.jproperty.Property;

public interface IntProperty extends ReadOnlyIntProperty, Property<Number> {

    void set(int value);

}

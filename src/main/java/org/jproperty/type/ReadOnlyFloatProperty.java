package org.jproperty.type;

import org.jproperty.ReadOnlyProperty;

public interface ReadOnlyFloatProperty extends ReadOnlyProperty<Number> {

    @Override
    Float getValue();

    float get();

}

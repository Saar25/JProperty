package org.jproperty.type;

import org.jproperty.ReadOnlyProperty;

public interface ReadOnlyNumberProperty extends ReadOnlyProperty<Number> {

    @Override
    Number getValue();

}

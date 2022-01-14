package org.jproperty.type;

import org.jproperty.ReadOnlyProperty;

public interface ReadOnlyBooleanProperty extends ReadOnlyProperty<Boolean> {

    @Override
    default Boolean getValue() {
        return get();
    }

    boolean get();

}

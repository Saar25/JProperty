package org.jproperty.type;

import org.jproperty.Property;

public interface BooleanProperty extends ReadOnlyBooleanProperty, Property<Boolean> {

    @Override
    default void setValue(Boolean value) {
        set(value);
    }

    void set(boolean value);

}

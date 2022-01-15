package org.jproperty.property;

import org.jproperty.Property;
import org.jproperty.value.ObservableBooleanValue;

public interface BooleanProperty extends ObservableBooleanValue, Property<Boolean> {

    @Override
    default void setValue(Boolean value) {
        set(value);
    }


    void set(boolean value);

}

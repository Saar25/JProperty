package org.jproperty.type;

import org.jproperty.Property;

public interface BooleanProperty extends ReadOnlyBooleanProperty, Property<Boolean> {

    void set(boolean value);

}

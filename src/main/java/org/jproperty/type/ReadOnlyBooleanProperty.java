package org.jproperty.type;

import org.jproperty.ReadOnlyProperty;

public interface ReadOnlyBooleanProperty extends ReadOnlyProperty<Boolean> {

    @Override
    Boolean getValue();

    boolean get();

}

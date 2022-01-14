package org.jproperty.type;

public interface ReadOnlyIntProperty extends ReadOnlyNumberProperty {

    @Override
    default Number getValue() {
        return get();
    }

    @Override
    default int getIntValue() {
        return get();
    }

    int get();

}

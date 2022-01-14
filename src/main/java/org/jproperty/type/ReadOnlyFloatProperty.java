package org.jproperty.type;

public interface ReadOnlyFloatProperty extends ReadOnlyNumberProperty {

    @Override
    default Number getValue() {
        return get();
    }

    @Override
    default float getFloatValue() {
        return get();
    }

    float get();

}

package org.saar.jproperty.type;

import org.saar.jproperty.ReadOnlyProperty;

public class ReadOnlyFloatProperty extends ReadOnlyNumberProperty implements ReadOnlyProperty<Number> {

    protected float value;

    public ReadOnlyFloatProperty() {
        this.value = 0f;
    }

    public ReadOnlyFloatProperty(float value) {
        this.value = value;
    }

    @Override
    public float getFloatValue() {
        return get();
    }

    @Override
    public Float getValue() {
        return get();
    }

    public float get() {
        return this.value;
    }
}

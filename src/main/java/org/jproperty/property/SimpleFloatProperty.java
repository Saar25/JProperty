package org.jproperty.property;

import org.jproperty.value.ObservableValueBase;

public class SimpleFloatProperty extends ObservableValueBase<Number> implements FloatProperty {

    private float value;

    public SimpleFloatProperty() {
    }

    public SimpleFloatProperty(float value) {
        this.value = value;
    }

    @Override
    public float get() {
        return this.value;
    }

    @Override
    public void set(float value) {
        if (get() != value) {
            float oldValue = this.value;
            this.value = value;

            fireChangeEvent(oldValue);
        }
    }

    @Override
    public String toString() {
        return "SimpleFloatProperty{" + get() + '}';
    }
}

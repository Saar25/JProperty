package org.jproperty.property;

import org.jproperty.ChangeEvent;

public class SimpleFloatProperty extends NumberPropertyBase implements FloatProperty {

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
            final ChangeEvent<Number> event = new ChangeEvent<>(this, this.value, value);

            this.value = value;
            this.helper.fireEvent(event);
        }
    }

    @Override
    public String toString() {
        return "SimpleFloatProperty{" + get() + '}';
    }
}

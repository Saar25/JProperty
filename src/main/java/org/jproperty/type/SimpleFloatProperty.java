package org.jproperty.type;

import org.jproperty.ChangeEventBase;

public class SimpleFloatProperty extends NumberPropertyBase implements FloatProperty {

    private float value;

    public SimpleFloatProperty() {
    }

    public SimpleFloatProperty(float value) {
        this.value = value;
    }

    @Override
    public Float getValue() {
        return get();
    }

    @Override
    public void setValue(Number value) {
        set(value.floatValue());
    }

    @Override
    public float get() {
        return this.value;
    }

    @Override
    public void set(float value) {
        if (get() != value) {
            final ChangeEventBase<Number> event = new ChangeEventBase<>(this, this.value, value);

            this.value = value;
            this.helper.fireEvent(event);
        }
    }

    @Override
    public String toString() {
        return "SimpleFloatProperty{" + get() + '}';
    }
}

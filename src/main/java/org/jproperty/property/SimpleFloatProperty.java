package org.jproperty.property;

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

package org.jproperty.type;

import org.jproperty.ChangeEventBase;
import org.jproperty.ReadOnlyProperty;
import org.jproperty.binding.Bindings;

public class SimpleFloatProperty extends NumberPropertyBase implements FloatProperty {

    private ReadOnlyProperty<? extends Number> bound = null;

    private float value;

    public SimpleFloatProperty() {
    }

    public SimpleFloatProperty(float value) {
        this.value = value;
    }

    @Override
    public void bind(ReadOnlyProperty<? extends Number> observable) {
        unbind();
        Bindings.bind(this, observable);
        this.bound = observable;
    }

    @Override
    public void unbind() {
        if (isBound()) {
            Bindings.unbind(this, this.bound);
            this.bound = null;
        }
    }

    @Override
    public boolean isBound() {
        return this.bound != null;
    }

    @Override
    public void setValue(Number value) {
        set(value.floatValue());
    }

    @Override
    public Float getValue() {
        return get();
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

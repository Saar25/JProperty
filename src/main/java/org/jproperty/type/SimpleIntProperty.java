package org.jproperty.type;

import org.jproperty.ChangeEventBase;
import org.jproperty.ReadOnlyProperty;
import org.jproperty.binding.Bindings;

public class SimpleIntProperty extends NumberPropertyBase implements IntProperty {

    private ReadOnlyProperty<? extends Number> bound = null;

    private int value;

    public SimpleIntProperty() {
    }

    public SimpleIntProperty(int value) {
        this.value = value;
    }

    @Override
    public void bind(ReadOnlyProperty<? extends Number> observable) {
        Bindings.bind(this, observable);
        this.bound = observable;
    }

    @Override
    public void unbind() {
        if (this.bound != null) {
            Bindings.unbind(this, this.bound);
            this.bound = null;
        }
    }

    @Override
    public boolean isBound() {
        return this.bound != null;
    }

    @Override
    public void setValue(int value) {
        set(value);
    }

    @Override
    public int getIntValue() {
        return get();
    }

    @Override
    public void setValue(Number value) {
        set(value.intValue());
    }

    @Override
    public Integer getValue() {
        return get();
    }

    @Override
    public int get() {
        return this.value;
    }

    @Override
    public void set(int value) {
        if (get() != value) {
            final ChangeEventBase<Number> event = new ChangeEventBase<>(this, this.value, value);

            this.value = value;
            this.helper.fireEvent(event);
        }
    }
}

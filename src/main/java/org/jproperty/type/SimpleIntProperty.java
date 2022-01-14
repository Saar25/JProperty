package org.jproperty.type;

import org.jproperty.ChangeEventBase;

public class SimpleIntProperty extends NumberPropertyBase implements IntProperty {

    private int value;

    public SimpleIntProperty() {
    }

    public SimpleIntProperty(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return get();
    }

    @Override
    public void setValue(Number value) {
        set(value.intValue());
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

    @Override
    public String toString() {
        return "SimpleIntProperty{" + get() + '}';
    }
}

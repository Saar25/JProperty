package org.jproperty.property;

import org.jproperty.value.ObservableValueBase;

public class SimpleIntegerProperty extends ObservableValueBase<Number> implements IntegerProperty {

    private int value;

    public SimpleIntegerProperty() {
    }

    public SimpleIntegerProperty(int value) {
        this.value = value;
    }

    @Override
    public int get() {
        return this.value;
    }

    @Override
    public void set(int value) {
        if (get() != value) {
            int oldValue = this.value;
            this.value = value;

            fireChangeEvent(oldValue);
        }
    }

    @Override
    public String toString() {
        return "SimpleIntProperty{" + get() + '}';
    }
}

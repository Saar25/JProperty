package org.jproperty.property;

import org.jproperty.value.ObservableValueBase;

public class SimpleBooleanProperty extends ObservableValueBase<Boolean> implements BooleanProperty {

    private boolean value;

    public SimpleBooleanProperty() {
    }

    public SimpleBooleanProperty(boolean value) {
        this.value = value;
    }

    @Override
    public boolean get() {
        return this.value;
    }

    @Override
    public void set(boolean value) {
        if (get() != value) {
            boolean oldValue = this.value;
            this.value = value;

            fireChangeEvent(oldValue);
        }
    }

    @Override
    public String toString() {
        return "SimpleBooleanProperty{" + get() + '}';
    }
}

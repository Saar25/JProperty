package org.jproperty.property;

import org.jproperty.ChangeEvent;

public class SimpleBooleanProperty extends BooleanPropertyBase implements BooleanProperty {

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
            final ChangeEvent<Boolean> event = new ChangeEvent<>(this, this.value, value);

            this.value = value;
            this.helper.fireEvent(event);
        }
    }

    @Override
    public String toString() {
        return "SimpleBooleanProperty{" + get() + '}';
    }
}

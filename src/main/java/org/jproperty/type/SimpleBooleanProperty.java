package org.jproperty.type;

import org.jproperty.ChangeEventBase;

public class SimpleBooleanProperty extends BooleanPropertyBase implements BooleanProperty {

    private boolean value;

    public SimpleBooleanProperty() {
    }

    public SimpleBooleanProperty(boolean value) {
        this.value = value;
    }

    @Override
    public Boolean getValue() {
        return get();
    }

    @Override
    public void setValue(Boolean value) {
        set(value);
    }

    @Override
    public boolean get() {
        return this.value;
    }

    @Override
    public void set(boolean value) {
        if (get() != value) {
            final ChangeEventBase<Boolean> event = new ChangeEventBase<>(this, this.value, value);

            this.value = value;
            this.helper.fireEvent(event);
        }
    }

    @Override
    public String toString() {
        return "SimpleBooleanProperty{" + get() + '}';
    }
}

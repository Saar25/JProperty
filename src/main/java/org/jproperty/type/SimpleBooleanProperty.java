package org.jproperty.type;

import org.jproperty.ChangeEventBase;
import org.jproperty.ReadOnlyProperty;
import org.jproperty.binding.Bindings;

public class SimpleBooleanProperty extends BooleanPropertyBase implements BooleanProperty {

    private ReadOnlyProperty<? extends Boolean> bound = null;

    private boolean value;

    public SimpleBooleanProperty() {
    }

    public SimpleBooleanProperty(boolean value) {
        this.value = value;
    }

    @Override
    public void bind(ReadOnlyProperty<? extends Boolean> observable) {
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

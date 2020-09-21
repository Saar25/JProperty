package org.jproperty.type;

import org.jproperty.ChangeEventBase;
import org.jproperty.Property;
import org.jproperty.ReadOnlyProperty;
import org.jproperty.binding.Bindings;

public class IntProperty extends ReadOnlyIntProperty implements Property<Number> {

    private ReadOnlyProperty<? extends Number> bound = null;

    public IntProperty() {
    }

    public IntProperty(int value) {
        super(value);
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
    public void bindBidirectional(Property<Number> observable) {
        Bindings.bindBidirectional(this, observable);
    }

    @Override
    public void unbindBidirectional(Property<Number> observable) {
        Bindings.unbindBidirectional(this, observable);
    }

    @Override
    public void setValue(Number value) {
        set(value.intValue());
    }

    public void set(int value) {
        if (get() != value) {
            final ChangeEventBase<Number> event = new ChangeEventBase<>(this, this.value, value);

            this.value = value;
            this.helper.fireEvent(event);
        }
    }
}
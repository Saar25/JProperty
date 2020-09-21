package org.jproperty.type;

import org.jproperty.ChangeEventBase;
import org.jproperty.Property;
import org.jproperty.ReadOnlyProperty;
import org.jproperty.binding.Bindings;

public class ObjectProperty<T> extends ReadOnlyObjectProperty<T> implements Property<T> {

    private ReadOnlyProperty<? extends T> bound = null;

    public ObjectProperty() {
    }

    public ObjectProperty(T value) {
        super(value);
    }

    @Override
    public void bind(ReadOnlyProperty<? extends T> observable) {
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
    public void bindBidirectional(Property<T> observable) {
        Bindings.bindBidirectional(this, observable);
    }

    @Override
    public void unbindBidirectional(Property<T> observable) {
        Bindings.unbindBidirectional(this, observable);
    }

    @Override
    public void setValue(T value) {
        if (this.value != value) {
            final ChangeEventBase<T> event = new ChangeEventBase<>(this, this.value, value);

            this.value = value;
            this.helper.fireEvent(event);
        }
    }
}

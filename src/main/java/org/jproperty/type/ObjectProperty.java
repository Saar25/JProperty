package org.jproperty.type;

import org.jproperty.*;
import org.jproperty.binding.Bindings;

public class ObjectProperty<T> implements ReadOnlyObjectProperty<T>, Property<T> {

    private ReadOnlyProperty<? extends T> bound = null;

    protected ListenersHelper<T> helper = ListenersHelper.empty();

    protected T value;

    public ObjectProperty() {
        this.value = null;
    }

    public ObjectProperty(T value) {
        this.value = value;
    }

    @Override
    public void addListener(ChangeListener<? super T> listener) {
        this.helper = this.helper.addListener(listener);
    }

    @Override
    public void removeListener(ChangeListener<? super T> listener) {
        this.helper = this.helper.removeListener(listener);
    }

    @Override
    public T getValue() {
        return this.value;
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

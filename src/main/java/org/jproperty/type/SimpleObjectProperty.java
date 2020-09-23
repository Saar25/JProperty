package org.jproperty.type;

import org.jproperty.*;
import org.jproperty.binding.Bindings;

public class SimpleObjectProperty<T> implements ObjectProperty<T> {

    private ReadOnlyProperty<? extends T> bound = null;

    protected ListenersHelper<T> helper = ListenersHelper.empty();

    protected T value;

    public SimpleObjectProperty() {
        this.value = null;
    }

    public SimpleObjectProperty(T value) {
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

    @Override
    public String toString() {
        return "SimpleObjectProperty{" + getValue() + '}';
    }
}

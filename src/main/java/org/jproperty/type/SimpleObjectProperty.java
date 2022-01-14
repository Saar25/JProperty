package org.jproperty.type;

import org.jproperty.ChangeEventBase;

public class SimpleObjectProperty<T> extends ObjectPropertyBase<T> implements ObjectProperty<T> {

    protected T value;

    public SimpleObjectProperty() {
        this.value = null;
    }

    public SimpleObjectProperty(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return this.value;
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

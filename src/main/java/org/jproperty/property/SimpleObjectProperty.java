package org.jproperty.property;

public class SimpleObjectProperty<T> extends ObjectPropertyBase<T> implements ObjectProperty<T> {

    protected T value;

    public SimpleObjectProperty() {
        this.value = null;
    }

    public SimpleObjectProperty(T value) {
        this.value = value;
    }

    @Override
    public T get() {
        return this.value;
    }

    @Override
    public void set(T value) {
        if (get() != value) {
            T oldValue = this.value;
            this.value = value;

            fireChangeEvent(oldValue);
        }
    }

    @Override
    public String toString() {
        return "SimpleObjectProperty{" + getValue() + '}';
    }
}

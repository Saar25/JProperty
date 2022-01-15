package org.jproperty.constant;

import org.jproperty.value.ObservableObjectValue;

public class ConstantObjectProperty<T> extends ConstantPropertyBase<T> implements ObservableObjectValue<T> {

    private final T value;

    public ConstantObjectProperty(T value) {
        this.value = value;
    }

    @Override
    public T get() {
        return this.value;
    }

    @Override
    public String toString() {
        return "ConstantObjectProperty{" + get() + '}';
    }
}

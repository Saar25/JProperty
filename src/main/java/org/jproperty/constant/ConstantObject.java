package org.jproperty.constant;

import org.jproperty.value.ObservableObjectValue;

public class ConstantObject<T> extends ConstantValueBase<T> implements ObservableObjectValue<T> {

    private final T value;

    public ConstantObject(T value) {
        this.value = value;
    }

    @Override
    public T get() {
        return this.value;
    }

    @Override
    public String toString() {
        return "ConstantObject{" + get() + '}';
    }
}

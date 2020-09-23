package org.jproperty.type;

public class ConstantObjectProperty<T> extends ConstantPropertyBase<T> implements ReadOnlyObjectProperty<T> {

    private final T value;

    public ConstantObjectProperty(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "ConstantObjectProperty{" + getValue() + '}';
    }
}

package org.jproperty;

public interface Property<T> extends ReadOnlyProperty<T> {

    void setValue(T value);
}

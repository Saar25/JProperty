package org.jproperty;

public interface Property<T> extends ObservableValue<T> {

    void setValue(T value);
}

package org.saar.jproperty;

public interface ChangeEvent<T> {

    ReadOnlyProperty<T> getProperty();

    T getOldValue();

    T getNewValue();
}

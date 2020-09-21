package org.saar.jproperty;

public interface ReadOnlyProperty<T> {

    void addListener(ChangeListener<? super T> listener);

    void removeListener(ChangeListener<? super T> listener);

    T getValue();

}

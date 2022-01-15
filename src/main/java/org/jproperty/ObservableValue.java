package org.jproperty;

public interface ObservableValue<T> {

    void addListener(ChangeListener<? super T> listener);

    void removeListener(ChangeListener<? super T> listener);

    T getValue();

}

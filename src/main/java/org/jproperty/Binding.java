package org.jproperty;

public interface Binding<T> extends ObservableValue<T> {

    void invalidate();

    void dispose();

}

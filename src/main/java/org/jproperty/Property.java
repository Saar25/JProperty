package org.jproperty;

public interface Property<T> extends ReadOnlyProperty<T> {

    void bind(ReadOnlyProperty<? extends T> observable);

    void unbind();

    void bindBidirectional(Property<T> observable);

    void unbindBidirectional(Property<T> observable);

    void setValue(T value);
}

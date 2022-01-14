package org.jproperty;

public interface Subscriber<T> {

    void onChange(ChangeEvent<? extends T> e);

}

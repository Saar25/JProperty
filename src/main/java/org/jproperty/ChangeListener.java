package org.jproperty;

public interface ChangeListener<T> {

    void onChange(ChangeEvent<? extends T> e);

}

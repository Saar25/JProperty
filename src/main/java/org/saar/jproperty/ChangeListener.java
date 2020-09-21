package org.saar.jproperty;

public interface ChangeListener<T> {

    void onChange(ChangeEvent<? extends T> e);

}

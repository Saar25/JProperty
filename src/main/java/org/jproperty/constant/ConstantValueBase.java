package org.jproperty.constant;

import org.jproperty.ChangeListener;
import org.jproperty.InvalidationListener;
import org.jproperty.ObservableValue;

public abstract class ConstantValueBase<T> implements ObservableValue<T> {

    @Override
    public void addListener(ChangeListener<? super T> listener) {
    }

    @Override
    public void removeListener(ChangeListener<? super T> listener) {
    }

    @Override
    public void addListener(InvalidationListener listener) {
    }

    @Override
    public void removeListener(InvalidationListener listener) {
    }
}

package org.jproperty.type;

import org.jproperty.ChangeListener;
import org.jproperty.ReadOnlyProperty;

public abstract class ConstantPropertyBase<T> implements ReadOnlyProperty<T> {

    @Override
    public void addListener(ChangeListener<? super T> listener) {
        // Value never changes
    }

    @Override
    public void removeListener(ChangeListener<? super T> listener) {
        // Value never changes
    }
}

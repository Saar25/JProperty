package org.jproperty.type;

import org.jproperty.ReadOnlyProperty;
import org.jproperty.Subscriber;
import org.jproperty.Subscription;

public abstract class ConstantPropertyBase<T> implements ReadOnlyProperty<T> {

    @Override
    public Subscription subscribe(Subscriber<? super T> listener) {
        return () -> {};
    }
}

package org.jproperty.property;

import org.jproperty.ChangeListener;
import org.jproperty.InvalidationListener;
import org.jproperty.ListenersHelper;
import org.jproperty.value.ObservableObjectValue;

public abstract class ObjectPropertyBase<T> implements ObservableObjectValue<T> {

    private final ListenersHelper<T> helper = ListenersHelper.empty();

    @Override
    public final void addListener(ChangeListener<? super T> listener) {
        this.helper.addListener(listener);
    }

    @Override
    public final void removeListener(ChangeListener<? super T> listener) {
        this.helper.removeListener(listener);
    }

    @Override
    public final void addListener(InvalidationListener listener) {
        this.helper.addListener(listener);
    }

    @Override
    public final void removeListener(InvalidationListener listener) {
        this.helper.removeListener(listener);
    }

    protected final void fireChangeEvent(T oldValue) {
        this.helper.fireChangeEvent(this, oldValue);
    }
}

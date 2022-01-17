package org.jproperty.value;

import org.jproperty.ChangeListener;
import org.jproperty.InvalidationListener;
import org.jproperty.ListenersHelper;
import org.jproperty.ObservableValue;

public abstract class ObservableValueBase<T> implements ObservableValue<T> {

    private final ListenersHelper<T> helper = new ListenersHelper<>();

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

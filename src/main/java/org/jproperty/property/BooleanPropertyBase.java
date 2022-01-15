package org.jproperty.property;

import org.jproperty.ChangeListener;
import org.jproperty.InvalidationListener;
import org.jproperty.ListenersHelper;
import org.jproperty.value.ObservableBooleanValue;

public abstract class BooleanPropertyBase implements ObservableBooleanValue {

    private final ListenersHelper<Boolean> helper = ListenersHelper.empty();

    @Override
    public final void addListener(ChangeListener<? super Boolean> listener) {
        this.helper.addListener(listener);
    }

    @Override
    public final void removeListener(ChangeListener<? super Boolean> listener) {
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

    protected final void fireChangeEvent(Boolean oldValue) {
        this.helper.fireChangeEvent(this, oldValue);
    }
}

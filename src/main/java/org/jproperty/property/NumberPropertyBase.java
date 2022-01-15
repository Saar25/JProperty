package org.jproperty.property;

import org.jproperty.ChangeListener;
import org.jproperty.InvalidationListener;
import org.jproperty.ListenersHelper;

public abstract class NumberPropertyBase implements NumberProperty {

    private final ListenersHelper<Number> helper = ListenersHelper.empty();

    @Override
    public final void addListener(ChangeListener<? super Number> listener) {
        this.helper.addListener(listener);
    }

    @Override
    public final void removeListener(ChangeListener<? super Number> listener) {
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

    protected final void fireChangeEvent(Number oldValue) {
        this.helper.fireChangeEvent(this, oldValue);
    }
}

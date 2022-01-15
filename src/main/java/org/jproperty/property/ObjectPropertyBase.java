package org.jproperty.property;

import org.jproperty.ChangeListener;
import org.jproperty.ChangeListenersHelper;
import org.jproperty.value.ObservableObjectValue;

public abstract class ObjectPropertyBase<T> implements ObservableObjectValue<T> {

    protected ChangeListenersHelper<T> helper = ChangeListenersHelper.empty();

    @Override
    public void addListener(ChangeListener<? super T> listener) {
        this.helper = this.helper.addListener(listener);
    }

    @Override
    public void removeListener(ChangeListener<? super T> listener) {
        this.helper = this.helper.removeListener(listener);
    }
}

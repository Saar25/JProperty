package org.jproperty.property;

import org.jproperty.ChangeListener;
import org.jproperty.ChangeListenersHelper;
import org.jproperty.value.ObservableNumberValue;

public abstract class NumberPropertyBase implements ObservableNumberValue {

    protected ChangeListenersHelper<Number> helper = ChangeListenersHelper.empty();

    @Override
    public void addListener(ChangeListener<? super Number> listener) {
        this.helper = this.helper.addListener(listener);
    }

    @Override
    public void removeListener(ChangeListener<? super Number> listener) {
        this.helper = this.helper.removeListener(listener);
    }
}

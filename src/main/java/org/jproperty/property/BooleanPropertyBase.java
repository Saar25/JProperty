package org.jproperty.property;

import org.jproperty.ChangeListener;
import org.jproperty.ChangeListenersHelper;
import org.jproperty.value.ObservableBooleanValue;

public abstract class BooleanPropertyBase implements ObservableBooleanValue {

    protected ChangeListenersHelper<Boolean> helper = ChangeListenersHelper.empty();

    @Override
    public void addListener(ChangeListener<? super Boolean> listener) {
        this.helper = this.helper.addListener(listener);
    }

    @Override
    public void removeListener(ChangeListener<? super Boolean> listener) {
        this.helper = this.helper.removeListener(listener);
    }
}

package org.jproperty.type;

import org.jproperty.ChangeListener;
import org.jproperty.ListenersHelper;
import org.jproperty.Property;
import org.jproperty.binding.Bindings;

public abstract class NumberPropertyBase implements NumberProperty {

    protected ListenersHelper<Number> helper = ListenersHelper.empty();

    @Override
    public void addListener(ChangeListener<? super Number> listener) {
        this.helper = this.helper.addListener(listener);
    }

    @Override
    public void removeListener(ChangeListener<? super Number> listener) {
        this.helper = this.helper.removeListener(listener);
    }

    @Override
    public void bindBidirectional(Property<Number> observable) {
        Bindings.bindBidirectional(this, observable);
    }

    @Override
    public void unbindBidirectional(Property<Number> observable) {
        Bindings.unbindBidirectional(this, observable);
    }
}

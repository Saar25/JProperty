package org.jproperty.type;

import org.jproperty.ChangeListener;
import org.jproperty.ListenersHelper;
import org.jproperty.Property;
import org.jproperty.binding.Bindings;

public abstract class BooleanPropertyBase implements BooleanProperty {

    protected ListenersHelper<Boolean> helper = ListenersHelper.empty();

    @Override
    public void addListener(ChangeListener<? super Boolean> listener) {
        this.helper = this.helper.addListener(listener);
    }

    @Override
    public void removeListener(ChangeListener<? super Boolean> listener) {
        this.helper = this.helper.removeListener(listener);
    }

    @Override
    public void bindBidirectional(Property<Boolean> observable) {
        Bindings.bindBidirectional(this, observable);
    }

    @Override
    public void unbindBidirectional(Property<Boolean> observable) {
        Bindings.unbindBidirectional(this, observable);
    }
}

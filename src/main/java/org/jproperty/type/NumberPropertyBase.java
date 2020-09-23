package org.jproperty.type;

import org.jproperty.ChangeListener;
import org.jproperty.ListenersHelper;
import org.jproperty.Property;
import org.jproperty.binding.Bindings;

public abstract class NumberPropertyBase implements Property<Number> {

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

    public int getIntValue() {
        return getValue().intValue();
    }

    public float getFloatValue() {
        return getValue().floatValue();
    }

    public long getLongValue() {
        return getValue().longValue();
    }

    public double getDoubleValue() {
        return getValue().doubleValue();
    }
}

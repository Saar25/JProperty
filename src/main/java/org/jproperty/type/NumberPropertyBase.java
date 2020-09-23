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

    @Override
    public int getIntValue() {
        return getValue().intValue();
    }

    @Override
    public float getFloatValue() {
        return getValue().floatValue();
    }

    @Override
    public long getLongValue() {
        return getValue().longValue();
    }

    @Override
    public double getDoubleValue() {
        return getValue().doubleValue();
    }

    @Override
    public void setValue(int value) {
        setValue(Integer.valueOf(value));
    }

    @Override
    public void setValue(long value) {
        setValue(Long.valueOf(value));
    }

    @Override
    public void setValue(float value) {
        setValue(Float.valueOf(value));
    }

    @Override
    public void setValue(double value) {
        setValue(Double.valueOf(value));
    }
}

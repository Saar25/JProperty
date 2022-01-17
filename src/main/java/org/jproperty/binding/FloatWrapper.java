package org.jproperty.binding;

import org.jproperty.Binding;
import org.jproperty.value.ObservableFloatValue;
import org.jproperty.value.ObservableNumberValue;

public class FloatWrapper extends FloatBinding implements Binding<Number>, ObservableFloatValue {

    private ObservableNumberValue observable;

    public FloatWrapper(ObservableNumberValue observable) {
        this.observable = observable;
        bind(this.observable);
    }

    public void set(ObservableNumberValue observable) {
        unbind(this.observable);
        this.observable = observable;
        bind(this.observable);

        invalidate();
    }

    @Override
    protected float compute() {
        return this.observable.getFloatValue();
    }
}

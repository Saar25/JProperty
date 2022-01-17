package org.jproperty.binding;

import org.jproperty.Binding;
import org.jproperty.value.ObservableIntegerValue;
import org.jproperty.value.ObservableNumberValue;

public class IntegerWrapper extends IntegerBinding implements Binding<Number>, ObservableIntegerValue {

    private ObservableNumberValue observable;

    public IntegerWrapper(ObservableNumberValue observable) {
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
    protected int compute() {
        return this.observable.getIntValue();
    }
}

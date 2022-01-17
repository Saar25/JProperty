package org.jproperty.binding;

import org.jproperty.Binding;
import org.jproperty.value.ObservableIntegerValue;

public abstract class IntegerBinding extends BindingBase<Number> implements Binding<Number>, ObservableIntegerValue {

    private int value;
    private boolean valid = false;

    @Override
    public final void invalidate() {
        if (this.valid) {
            this.valid = false;
            fireChangeEvent(this.value);
        }
    }

    @Override
    public void dispose() {
    }

    @Override
    public final int get() {
        if (!this.valid) {
            this.value = compute();
            this.valid = true;
        }

        return this.value;
    }

    protected abstract int compute();
}

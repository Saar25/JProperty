package org.jproperty.binding;

import org.jproperty.Binding;
import org.jproperty.value.ObservableBooleanValue;

public abstract class BooleanBinding extends BindingBase<Boolean> implements Binding<Boolean>, ObservableBooleanValue {

    private boolean value;
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
    public final boolean get() {
        if (!this.valid) {
            this.value = compute();
            this.valid = true;
        }

        return this.value;
    }

    protected abstract boolean compute();
}

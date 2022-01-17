package org.jproperty.binding;

import org.jproperty.Binding;
import org.jproperty.value.ObservableFloatValue;

public abstract class FloatBinding extends BindingBase<Number> implements Binding<Number>, ObservableFloatValue {

    private float value;
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
    public final float get() {
        if (!this.valid) {
            this.value = compute();
            this.valid = true;
        }

        return this.value;
    }

    protected abstract float compute();
}

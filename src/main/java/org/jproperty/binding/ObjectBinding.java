package org.jproperty.binding;

import org.jproperty.Binding;
import org.jproperty.value.ObservableObjectValue;

public abstract class ObjectBinding<T> extends BindingBase<T> implements Binding<T>, ObservableObjectValue<T> {

    private T value;
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
    public final T get() {
        if (!this.valid) {
            this.value = compute();
            this.valid = true;
        }

        return this.value;
    }

    protected abstract T compute();
}

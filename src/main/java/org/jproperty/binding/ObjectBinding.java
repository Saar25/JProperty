package org.jproperty.binding;

import org.jproperty.Binding;
import org.jproperty.Observable;
import org.jproperty.value.ObservableObjectValue;

public abstract class ObjectBinding<T> extends BindingBase<T> implements Binding<T>, ObservableObjectValue<T> {

    private final Observable[] dependencies;

    private T value;
    private boolean valid = false;

    public ObjectBinding(Observable... dependencies) {
        this.dependencies = dependencies;
        bind(this.dependencies);
    }

    @Override
    public final void invalidate() {
        if (this.valid) {
            this.valid = false;
            fireChangeEvent(this.value);
        }
    }

    @Override
    public final void dispose() {
        unbind(this.dependencies);
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

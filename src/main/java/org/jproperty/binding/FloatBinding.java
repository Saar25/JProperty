package org.jproperty.binding;

import org.jproperty.Binding;
import org.jproperty.Observable;
import org.jproperty.value.ObservableFloatValue;

public abstract class FloatBinding extends BindingBase<Number> implements Binding<Number>, ObservableFloatValue {

    private final Observable[] dependencies;

    private float value;
    private boolean valid = false;

    public FloatBinding(Observable... dependencies) {
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
    public final float get() {
        if (!this.valid) {
            this.value = compute();
            this.valid = true;
        }

        return this.value;
    }

    protected abstract float compute();
}

package org.jproperty.binding;

import org.jproperty.Binding;
import org.jproperty.Observable;
import org.jproperty.value.ObservableBooleanValue;
import org.jproperty.value.ObservableValueBase;

public abstract class BooleanBinding extends ObservableValueBase<Boolean> implements Binding<Boolean>, ObservableBooleanValue {

    private final InvalidationObserver observer = new InvalidationObserver(this);
    private final Observable[] dependencies;

    private boolean value;
    private boolean valid = false;

    public BooleanBinding(Observable... dependencies) {
        this.dependencies = dependencies;
        bind(this.dependencies);
    }

    private void bind(Observable... dependencies) {
        for (Observable dependency : dependencies) {
            dependency.addListener(this.observer);
        }
    }

    private void unbind(Observable... dependencies) {
        for (Observable dependency : dependencies) {
            dependency.removeListener(this.observer);
        }
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
    public final boolean get() {
        if (!this.valid) {
            this.value = compute();
            this.valid = true;
        }

        return this.value;
    }

    protected abstract boolean compute();
}

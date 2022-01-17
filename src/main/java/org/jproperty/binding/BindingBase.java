package org.jproperty.binding;

import org.jproperty.Binding;
import org.jproperty.Observable;
import org.jproperty.value.ObservableValueBase;

public abstract class BindingBase<T> extends ObservableValueBase<T> implements Binding<T> {

    private final InvalidationObserver observer = new InvalidationObserver(this);

    protected final void bind(Observable... dependencies) {
        for (Observable dependency : dependencies) {
            dependency.addListener(this.observer);
        }
    }

    protected final void unbind(Observable... dependencies) {
        for (Observable dependency : dependencies) {
            dependency.removeListener(this.observer);
        }
    }
}

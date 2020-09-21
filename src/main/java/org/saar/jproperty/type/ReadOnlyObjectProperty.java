package org.saar.jproperty.type;

import org.saar.jproperty.ChangeListener;
import org.saar.jproperty.ListenersHelper;
import org.saar.jproperty.ReadOnlyProperty;

public class ReadOnlyObjectProperty<T> implements ReadOnlyProperty<T> {

    protected ListenersHelper<T> helper = ListenersHelper.empty();

    protected T value;

    public ReadOnlyObjectProperty() {
        this.value = null;
    }

    public ReadOnlyObjectProperty(T value) {
        this.value = value;
    }

    @Override
    public void addListener(ChangeListener<? super T> listener) {
        this.helper = this.helper.addListener(listener);
    }

    @Override
    public void removeListener(ChangeListener<? super T> listener) {
        this.helper = this.helper.removeListener(listener);
    }

    @Override
    public T getValue() {
        return this.value;
    }
}
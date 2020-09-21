package org.jproperty.type;

import org.jproperty.ChangeListener;
import org.jproperty.ListenersHelper;
import org.jproperty.ReadOnlyProperty;

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

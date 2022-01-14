package org.jproperty.type;

import org.jproperty.*;

public class SimpleObjectProperty<T> implements ObjectProperty<T> {

    protected SubscribersHelper<T> helper = SubscribersHelper.empty();

    protected T value;

    public SimpleObjectProperty() {
        this.value = null;
    }

    public SimpleObjectProperty(T value) {
        this.value = value;
    }

    @Override
    public Subscription subscribe(Subscriber<? super T> listener) {
        this.helper = this.helper.addSubscriber(listener);

        return () -> this.helper = this.helper.removeSubscriber(listener);
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public void setValue(T value) {
        if (this.value != value) {
            final ChangeEventBase<T> event = new ChangeEventBase<>(this, this.value, value);

            this.value = value;
            this.helper.fireEvent(event);
        }
    }

    @Override
    public String toString() {
        return "SimpleObjectProperty{" + getValue() + '}';
    }
}

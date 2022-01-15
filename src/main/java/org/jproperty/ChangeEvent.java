package org.jproperty;

public final class ChangeEvent<T> {

    private final ObservableValue<T> observable;
    private final T oldValue;

    public ChangeEvent(ObservableValue<T> property, T oldValue) {
        this.observable = property;
        this.oldValue = oldValue;
    }

    public ObservableValue<T> getObservable() {
        return this.observable;
    }

    public T getOldValue() {
        return this.oldValue;
    }
}

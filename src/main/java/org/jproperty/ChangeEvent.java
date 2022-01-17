package org.jproperty;

public final class ChangeEvent<T> {

    private final ObservableValue<T> observable;
    private final T oldValue;
    private final T newValue;

    public ChangeEvent(ObservableValue<T> observable, T oldValue, T newValue) {
        this.observable = observable;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public ObservableValue<T> getObservable() {
        return this.observable;
    }

    public T getOldValue() {
        return this.oldValue;
    }

    public T getNewValue() {
        return this.newValue;
    }
}

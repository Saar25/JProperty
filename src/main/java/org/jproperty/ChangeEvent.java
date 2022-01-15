package org.jproperty;

public final class ChangeEvent<T> {

    private final ObservableValue<T> property;
    private final T oldValue;
    private final T newValue;

    public ChangeEvent(ObservableValue<T> property, T oldValue, T newValue) {
        this.property = property;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public ObservableValue<T> getProperty() {
        return this.property;
    }

    public T getOldValue() {
        return this.oldValue;
    }

    public T getNewValue() {
        return this.newValue;
    }
}

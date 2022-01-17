package org.jproperty;

public class ListenersHelper<T> {

    private ChangeListenersHelper<T> changeHelper = ChangeListenersHelper.empty();
    private InvalidationListenersHelper invalidationHelper = InvalidationListenersHelper.empty();


    public void addListener(ChangeListener<? super T> listener) {
        this.changeHelper = this.changeHelper.addListener(listener);
    }

    public void removeListener(ChangeListener<? super T> listener) {
        this.changeHelper = this.changeHelper.removeListener(listener);
    }

    public void addListener(InvalidationListener listener) {
        this.invalidationHelper = this.invalidationHelper.addListener(listener);
    }

    public void removeListener(InvalidationListener listener) {
        this.invalidationHelper = this.invalidationHelper.removeListener(listener);
    }

    public void fireChangeEvent(ObservableValue<T> observable, T oldValue) {
        this.changeHelper.fireEvent(observable, oldValue);
        this.invalidationHelper.fireEvent(observable);
    }
}

package org.jproperty;

public class ListenersHelper<T> {

    private static final ListenersHelper<?> EMPTY = new ListenersHelper<>(
            ChangeListenersHelper.empty(), InvalidationListenersHelper.empty());

    private ChangeListenersHelper<T> changeHelper;
    private InvalidationListenersHelper invalidationHelper;

    public ListenersHelper(ChangeListenersHelper<T> changeHelper, InvalidationListenersHelper invalidationHelper) {
        this.changeHelper = changeHelper;
        this.invalidationHelper = invalidationHelper;
    }

    @SuppressWarnings("unchecked")
    public static <T> ListenersHelper<T> empty() {
        return (ListenersHelper<T>) ListenersHelper.EMPTY;
    }

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
        this.changeHelper.fireEvent(new ChangeEvent<>(observable, oldValue));
        this.invalidationHelper.fireEvent(observable);

    }
}

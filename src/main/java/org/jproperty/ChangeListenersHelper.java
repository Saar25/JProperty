package org.jproperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ChangeListenersHelper<T> {

    @SuppressWarnings("unchecked")
    public static <T> ChangeListenersHelper<T> empty() {
        return (ChangeListenersHelper<T>) ChangeListenersHelper.Empty.INSTANCE;
    }

    public abstract ChangeListenersHelper<T> addListener(ChangeListener<? super T> listener);

    public abstract ChangeListenersHelper<T> removeListener(ChangeListener<? super T> listener);

    public abstract void fireEvent(ChangeEvent<? extends T> event);

    private static class Empty<T> extends ChangeListenersHelper<T> {

        private static final Empty<?> INSTANCE = new Empty<>();

        @Override
        public ChangeListenersHelper<T> addListener(ChangeListener<? super T> listener) {
            return listener == null ? this : new SingleChange<>(listener);
        }

        @Override
        public ChangeListenersHelper<T> removeListener(ChangeListener<? super T> listener) {
            return this;
        }

        @Override
        public void fireEvent(ChangeEvent<? extends T> event) {

        }
    }

    private static class SingleChange<T> extends ChangeListenersHelper<T> {

        private final ChangeListener<? super T> listener;

        public SingleChange(ChangeListener<? super T> listener) {
            this.listener = listener;
        }

        @Override
        public ChangeListenersHelper<T> addListener(ChangeListener<? super T> listener) {
            return listener == null ? this : new Generic<>(
                    Arrays.asList(this.listener, listener));
        }

        @Override
        public ChangeListenersHelper<T> removeListener(ChangeListener<? super T> listener) {
            return this.listener != listener ? this : new Empty<>();
        }

        @Override
        public void fireEvent(ChangeEvent<? extends T> event) {
            this.listener.onChange(event);
        }
    }

    private static class Generic<T> extends ChangeListenersHelper<T> {

        private final List<ChangeListener<? super T>> listeners;

        public Generic(List<ChangeListener<? super T>> listeners) {
            this.listeners = listeners;
        }

        @Override
        public ChangeListenersHelper<T> addListener(ChangeListener<? super T> listener) {
            if (listener == null) return this;
            final List<ChangeListener<? super T>> listeners =
                    new ArrayList<>(this.listeners);
            listeners.add(listener);

            return new Generic<>(listeners);
        }

        @Override
        public ChangeListenersHelper<T> removeListener(ChangeListener<? super T> listener) {
            if (listener == null || !this.listeners.contains(listener)) {
                return this;
            }
            final List<ChangeListener<? super T>> listeners =
                    new ArrayList<>(this.listeners);
            listeners.removeIf(listener::equals);

            return new Generic<>(listeners);
        }

        @Override
        public void fireEvent(ChangeEvent<? extends T> event) {
            for (ChangeListener<? super T> listener : this.listeners) {
                listener.onChange(event);
            }
        }
    }

}

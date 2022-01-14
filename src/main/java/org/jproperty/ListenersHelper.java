package org.jproperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ListenersHelper<T> {

    public static <T> ListenersHelper<T> empty() {
        return new Empty<>();
    }

    public abstract ListenersHelper<T> addListener(Subscriber<? super T> listener);

    public abstract ListenersHelper<T> removeListener(Subscriber<? super T> listener);

    public abstract void fireEvent(ChangeEvent<T> event);

    private static class Empty<T> extends ListenersHelper<T> {

        @Override
        public ListenersHelper<T> addListener(Subscriber<? super T> listener) {
            return listener == null ? this : new SingleChange<>(listener);
        }

        @Override
        public ListenersHelper<T> removeListener(Subscriber<? super T> listener) {
            return this;
        }

        @Override
        public void fireEvent(ChangeEvent<T> event) {

        }
    }

    private static class SingleChange<T> extends ListenersHelper<T> {

        private final Subscriber<? super T> listener;

        public SingleChange(Subscriber<? super T> listener) {
            this.listener = listener;
        }

        @Override
        public ListenersHelper<T> addListener(Subscriber<? super T> listener) {
            return listener == null ? this : new Generic<>(
                    Arrays.asList(this.listener, listener));
        }

        @Override
        public ListenersHelper<T> removeListener(Subscriber<? super T> listener) {
            return this.listener != listener ? this : new Empty<>();
        }

        @Override
        public void fireEvent(ChangeEvent<T> event) {
            this.listener.onChange(event);
        }
    }

    private static class Generic<T> extends ListenersHelper<T> {

        private final List<Subscriber<? super T>> listeners;

        public Generic(List<Subscriber<? super T>> listeners) {
            this.listeners = listeners;
        }

        @Override
        public ListenersHelper<T> addListener(Subscriber<? super T> listener) {
            if (listener == null) return this;
            final List<Subscriber<? super T>> listeners =
                    new ArrayList<>(this.listeners);
            listeners.add(listener);

            return new Generic<>(listeners);
        }

        @Override
        public ListenersHelper<T> removeListener(Subscriber<? super T> listener) {
            if (listener == null || !this.listeners.contains(listener)) {
                return this;
            }
            final List<Subscriber<? super T>> listeners =
                    new ArrayList<>(this.listeners);
            listeners.removeIf(listener::equals);

            return new Generic<>(listeners);
        }

        @Override
        public void fireEvent(ChangeEvent<T> event) {
            for (Subscriber<? super T> listener : this.listeners) {
                listener.onChange(event);
            }
        }
    }

}

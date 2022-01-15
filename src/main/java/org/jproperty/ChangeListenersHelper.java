package org.jproperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ChangeListenersHelper<T> {

    public static <T> ChangeListenersHelper<T> empty() {
        return new Empty<>();
    }

    public abstract ChangeListenersHelper<T> addListener(ChangeListener<? super T> subscriber);

    public abstract ChangeListenersHelper<T> removeListener(ChangeListener<? super T> subscriber);

    public abstract void fireEvent(ChangeEvent<? extends T> event);

    private static class Empty<T> extends ChangeListenersHelper<T> {

        @Override
        public ChangeListenersHelper<T> addListener(ChangeListener<? super T> subscriber) {
            return subscriber == null ? this : new SingleChange<>(subscriber);
        }

        @Override
        public ChangeListenersHelper<T> removeListener(ChangeListener<? super T> subscriber) {
            return this;
        }

        @Override
        public void fireEvent(ChangeEvent<? extends T> event) {

        }
    }

    private static class SingleChange<T> extends ChangeListenersHelper<T> {

        private final ChangeListener<? super T> subscriber;

        public SingleChange(ChangeListener<? super T> subscriber) {
            this.subscriber = subscriber;
        }

        @Override
        public ChangeListenersHelper<T> addListener(ChangeListener<? super T> subscriber) {
            return subscriber == null ? this : new Generic<>(
                    Arrays.asList(this.subscriber, subscriber));
        }

        @Override
        public ChangeListenersHelper<T> removeListener(ChangeListener<? super T> subscriber) {
            return this.subscriber != subscriber ? this : new Empty<>();
        }

        @Override
        public void fireEvent(ChangeEvent<? extends T> event) {
            this.subscriber.onChange(event);
        }
    }

    private static class Generic<T> extends ChangeListenersHelper<T> {

        private final List<ChangeListener<? super T>> subscribers;

        public Generic(List<ChangeListener<? super T>> subscribers) {
            this.subscribers = subscribers;
        }

        @Override
        public ChangeListenersHelper<T> addListener(ChangeListener<? super T> subscriber) {
            if (subscriber == null) return this;
            final List<ChangeListener<? super T>> subscribers =
                    new ArrayList<>(this.subscribers);
            subscribers.add(subscriber);

            return new Generic<>(subscribers);
        }

        @Override
        public ChangeListenersHelper<T> removeListener(ChangeListener<? super T> subscriber) {
            if (subscriber == null || !this.subscribers.contains(subscriber)) {
                return this;
            }
            final List<ChangeListener<? super T>> subscribers =
                    new ArrayList<>(this.subscribers);
            subscribers.removeIf(subscriber::equals);

            return new Generic<>(subscribers);
        }

        @Override
        public void fireEvent(ChangeEvent<? extends T> event) {
            for (ChangeListener<? super T> subscriber : this.subscribers) {
                subscriber.onChange(event);
            }
        }
    }

}

package org.jproperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class SubscribersHelper<T> {

    public static <T> SubscribersHelper<T> empty() {
        return new Empty<>();
    }

    public abstract SubscribersHelper<T> addSubscriber(Subscriber<? super T> subscriber);

    public abstract SubscribersHelper<T> removeSubscriber(Subscriber<? super T> subscriber);

    public abstract void fireEvent(ChangeEvent<T> event);

    private static class Empty<T> extends SubscribersHelper<T> {

        @Override
        public SubscribersHelper<T> addSubscriber(Subscriber<? super T> subscriber) {
            return subscriber == null ? this : new SingleChange<>(subscriber);
        }

        @Override
        public SubscribersHelper<T> removeSubscriber(Subscriber<? super T> subscriber) {
            return this;
        }

        @Override
        public void fireEvent(ChangeEvent<T> event) {

        }
    }

    private static class SingleChange<T> extends SubscribersHelper<T> {

        private final Subscriber<? super T> subscriber;

        public SingleChange(Subscriber<? super T> subscriber) {
            this.subscriber = subscriber;
        }

        @Override
        public SubscribersHelper<T> addSubscriber(Subscriber<? super T> subscriber) {
            return subscriber == null ? this : new Generic<>(
                    Arrays.asList(this.subscriber, subscriber));
        }

        @Override
        public SubscribersHelper<T> removeSubscriber(Subscriber<? super T> subscriber) {
            return this.subscriber != subscriber ? this : new Empty<>();
        }

        @Override
        public void fireEvent(ChangeEvent<T> event) {
            this.subscriber.onChange(event);
        }
    }

    private static class Generic<T> extends SubscribersHelper<T> {

        private final List<Subscriber<? super T>> subscribers;

        public Generic(List<Subscriber<? super T>> subscribers) {
            this.subscribers = subscribers;
        }

        @Override
        public SubscribersHelper<T> addSubscriber(Subscriber<? super T> subscriber) {
            if (subscriber == null) return this;
            final List<Subscriber<? super T>> subscribers =
                    new ArrayList<>(this.subscribers);
            subscribers.add(subscriber);

            return new Generic<>(subscribers);
        }

        @Override
        public SubscribersHelper<T> removeSubscriber(Subscriber<? super T> subscriber) {
            if (subscriber == null || !this.subscribers.contains(subscriber)) {
                return this;
            }
            final List<Subscriber<? super T>> subscribers =
                    new ArrayList<>(this.subscribers);
            subscribers.removeIf(subscriber::equals);

            return new Generic<>(subscribers);
        }

        @Override
        public void fireEvent(ChangeEvent<T> event) {
            for (Subscriber<? super T> subscriber : this.subscribers) {
                subscriber.onChange(event);
            }
        }
    }

}

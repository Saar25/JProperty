package org.jproperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class InvalidationListenersHelper {

    public static InvalidationListenersHelper empty() {
        return InvalidationListenersHelper.Empty.INSTANCE;
    }

    public abstract InvalidationListenersHelper addListener(InvalidationListener listener);

    public abstract InvalidationListenersHelper removeListener(InvalidationListener listener);

    public abstract void fireEvent(Observable observable);

    private static class Empty extends InvalidationListenersHelper {

        private static final Empty INSTANCE = new Empty();

        @Override
        public InvalidationListenersHelper addListener(InvalidationListener listener) {
            return listener == null ? this : new SingleInvalidation(listener);
        }

        @Override
        public InvalidationListenersHelper removeListener(InvalidationListener listener) {
            return this;
        }

        @Override
        public void fireEvent(Observable observable) {

        }
    }

    private static class SingleInvalidation extends InvalidationListenersHelper {

        private final InvalidationListener listener;

        public SingleInvalidation(InvalidationListener listener) {
            this.listener = listener;
        }

        @Override
        public InvalidationListenersHelper addListener(InvalidationListener listener) {
            return listener == null ? this : new Generic(
                    Arrays.asList(this.listener, listener));
        }

        @Override
        public InvalidationListenersHelper removeListener(InvalidationListener listener) {
            return this.listener != listener ? this : new Empty();
        }

        @Override
        public void fireEvent(Observable observable) {
            this.listener.onInvalidation(observable);
        }
    }

    private static class Generic extends InvalidationListenersHelper {

        private final List<InvalidationListener> listeners;

        public Generic(List<InvalidationListener> listeners) {
            this.listeners = listeners;
        }

        @Override
        public InvalidationListenersHelper addListener(InvalidationListener listener) {
            if (listener == null) return this;
            final List<InvalidationListener> listeners =
                    new ArrayList<>(this.listeners);
            listeners.add(listener);

            return new Generic(listeners);
        }

        @Override
        public InvalidationListenersHelper removeListener(InvalidationListener listener) {
            if (listener == null || !this.listeners.contains(listener)) {
                return this;
            }
            final List<InvalidationListener> listeners =
                    new ArrayList<>(this.listeners);
            listeners.removeIf(listener::equals);

            return new Generic(listeners);
        }

        @Override
        public void fireEvent(Observable observable) {
            for (InvalidationListener listener : this.listeners) {
                listener.onInvalidation(observable);
            }
        }
    }

}

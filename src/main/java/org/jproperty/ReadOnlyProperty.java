package org.jproperty;

public interface ReadOnlyProperty<T> {

    Subscription subscribe(Subscriber<? super T> listener);

    T getValue();

}

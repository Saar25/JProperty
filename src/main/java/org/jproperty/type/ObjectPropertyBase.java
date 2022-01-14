package org.jproperty.type;

import org.jproperty.Subscriber;
import org.jproperty.SubscribersHelper;
import org.jproperty.Subscription;

public abstract class ObjectPropertyBase<T> implements ReadOnlyObjectProperty<T> {

    protected SubscribersHelper<T> helper = SubscribersHelper.empty();

    @Override
    public Subscription subscribe(Subscriber<? super T> listener) {
        this.helper = this.helper.addSubscriber(listener);

        return () -> this.helper = this.helper.removeSubscriber(listener);
    }
}

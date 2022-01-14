package org.jproperty.type;

import org.jproperty.Subscriber;
import org.jproperty.SubscribersHelper;
import org.jproperty.Subscription;

public abstract class NumberPropertyBase implements NumberProperty {

    protected SubscribersHelper<Number> helper = SubscribersHelper.empty();

    @Override
    public Subscription subscribe(Subscriber<? super Number> listener) {
        this.helper = this.helper.addSubscriber(listener);

        return () -> this.helper = this.helper.removeSubscriber(listener);
    }
}

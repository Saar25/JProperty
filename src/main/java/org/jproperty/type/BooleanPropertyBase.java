package org.jproperty.type;

import org.jproperty.Subscriber;
import org.jproperty.SubscribersHelper;
import org.jproperty.Subscription;

public abstract class BooleanPropertyBase implements BooleanProperty {

    protected SubscribersHelper<Boolean> helper = SubscribersHelper.empty();

    @Override
    public Subscription subscribe(Subscriber<? super Boolean> listener) {
        this.helper = this.helper.addSubscriber(listener);

        return () -> this.helper = this.helper.removeSubscriber(listener);
    }
}

package org.jproperty.type;

import org.jproperty.SubscribersHelper;
import org.jproperty.Property;
import org.jproperty.Subscriber;
import org.jproperty.Subscription;
import org.jproperty.binding.Bindings;

public abstract class NumberPropertyBase implements NumberProperty {

    protected SubscribersHelper<Number> helper = SubscribersHelper.empty();

    @Override
    public Subscription subscribe(Subscriber<? super Number> listener) {
        this.helper = this.helper.addSubscriber(listener);

        return () -> this.helper = this.helper.removeSubscriber(listener);
    }

    @Override
    public void bindBidirectional(Property<Number> observable) {
        Bindings.bindBidirectional(this, observable);
    }

    @Override
    public void unbindBidirectional(Property<Number> observable) {
        Bindings.unbindBidirectional(this, observable);
    }
}

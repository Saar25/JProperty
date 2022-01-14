package org.jproperty.type;

import org.jproperty.SubscribersHelper;
import org.jproperty.Property;
import org.jproperty.Subscriber;
import org.jproperty.Subscription;
import org.jproperty.binding.Bindings;

public abstract class BooleanPropertyBase implements BooleanProperty {

    protected SubscribersHelper<Boolean> helper = SubscribersHelper.empty();

    @Override
    public Subscription subscribe(Subscriber<? super Boolean> listener) {
        this.helper = this.helper.addSubscriber(listener);

        return () -> this.helper = this.helper.removeSubscriber(listener);
    }

    @Override
    public void bindBidirectional(Property<Boolean> observable) {
        Bindings.bindBidirectional(this, observable);
    }

    @Override
    public void unbindBidirectional(Property<Boolean> observable) {
        Bindings.unbindBidirectional(this, observable);
    }
}

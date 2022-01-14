package org.jproperty.expression;

import org.jproperty.Subscription;
import org.jproperty.type.NumberPropertyBase;
import org.jproperty.type.ReadOnlyIntProperty;

import java.util.List;

public class IntExpression extends NumberPropertyBase implements ReadOnlyIntProperty, Subscription {

    private final ReadOnlyIntProperty property;
    private final List<Subscription> dependentSubscriptions;
    private final Subscription changesSubscription;

    public IntExpression(ReadOnlyIntProperty property, List<Subscription> dependentSubscriptions) {
        this.property = property;
        this.dependentSubscriptions = dependentSubscriptions;
        this.changesSubscription = property.subscribe(e -> this.helper.fireEvent(e));
    }

    @Override
    public int get() {
        return this.property.get();
    }

    @Override
    public void unsubscribe() {
        this.changesSubscription.unsubscribe();
        this.dependentSubscriptions.forEach(Subscription::unsubscribe);
    }
}

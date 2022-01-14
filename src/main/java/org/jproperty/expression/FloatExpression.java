package org.jproperty.expression;

import org.jproperty.Subscription;
import org.jproperty.type.NumberPropertyBase;
import org.jproperty.type.ReadOnlyFloatProperty;

import java.util.List;

public class FloatExpression extends NumberPropertyBase implements ReadOnlyFloatProperty, Subscription {

    private final ReadOnlyFloatProperty property;
    private final List<Subscription> dependentSubscriptions;
    private final Subscription changesSubscription;

    public FloatExpression(ReadOnlyFloatProperty property, List<Subscription> dependentSubscriptions) {
        this.property = property;
        this.dependentSubscriptions = dependentSubscriptions;
        this.changesSubscription = property.subscribe(e -> this.helper.fireEvent(e));
    }

    @Override
    public float get() {
        return this.property.get();
    }

    @Override
    public void unsubscribe() {
        this.changesSubscription.unsubscribe();
        this.dependentSubscriptions.forEach(Subscription::unsubscribe);
    }
}

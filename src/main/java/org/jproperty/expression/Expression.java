package org.jproperty.expression;

import org.jproperty.Subscription;
import org.jproperty.type.ObjectPropertyBase;
import org.jproperty.type.ReadOnlyObjectProperty;

import java.util.List;

public class Expression<T> extends ObjectPropertyBase<T> implements Subscription {

    private final ReadOnlyObjectProperty<T> property;
    private final List<Subscription> dependentSubscriptions;
    private final Subscription changesSubscription;

    public Expression(ReadOnlyObjectProperty<T> property, List<Subscription> dependentSubscriptions) {
        this.property = property;
        this.dependentSubscriptions = dependentSubscriptions;
        this.changesSubscription = property.subscribe(e -> this.helper.fireEvent(e));
    }

    @Override
    public T getValue() {
        return property.getValue();
    }

    @Override
    public void unsubscribe() {
        this.changesSubscription.unsubscribe();
        this.dependentSubscriptions.forEach(Subscription::unsubscribe);
    }
}

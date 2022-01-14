package org.jproperty.binding;

import org.jproperty.Property;
import org.jproperty.ReadOnlyProperty;

public final class Bindings {

    private Bindings() {
        throw new AssertionError("Cannot create instance of class "
                + getClass().getSimpleName());
    }

    public static <T> void bind(Property<T> property1, ReadOnlyProperty<? extends T> property2) {
        property1.setValue(property2.getValue());
        property2.subscribe(UnidirectionalBinding.bind(property1));
    }

    public static <T> void unbind(Property<T> property1, ReadOnlyProperty<? extends T> property2) {
        // Remove this later
    }

    public static <T> void bindBidirectional(Property<T> property1, Property<T> property2) {
        property1.setValue(property2.getValue());
        final BidirectionalBinding<T> bind = BidirectionalBinding.bind(property1, property2);
        property1.subscribe(bind);
        property2.subscribe(bind);
    }

    public static <T> void unbindBidirectional(Property<T> property1, Property<T> property2) {
        // Remove this later
    }
}

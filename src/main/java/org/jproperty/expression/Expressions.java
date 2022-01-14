package org.jproperty.expression;

import org.jproperty.ReadOnlyProperty;
import org.jproperty.Subscription;
import org.jproperty.type.*;

import java.util.Collections;
import java.util.function.Function;

public class Expressions {

    private Expressions() {
        throw new AssertionError("Cannot create instance of " + getClass().getSimpleName());
    }

    public static <I, O> Expression<O> map(ReadOnlyProperty<? extends I> property, Function<? super I, ? extends O> mapper) {
        final ObjectProperty<O> result = new SimpleObjectProperty<>(mapper.apply(property.getValue()));

        final Subscription subscription = property.subscribe(e ->
                result.setValue(mapper.apply(property.getValue()))
        );

        return new Expression<>(result, Collections.singletonList(subscription));
    }

    public static <T> IntExpression mapToInt(ReadOnlyProperty<? extends T> property, Function<? super T, Integer> mapper) {
        final IntProperty result = new SimpleIntProperty(mapper.apply(property.getValue()));

        final Subscription subscription = property.subscribe(e ->
                result.setValue(mapper.apply(property.getValue()))
        );

        return new IntExpression(result, Collections.singletonList(subscription));
    }

    public static <T> FloatExpression mapToFloat(ReadOnlyProperty<? extends T> property, Function<? super T, Float> mapper) {
        final FloatProperty result = new SimpleFloatProperty(mapper.apply(property.getValue()));

        final Subscription subscription = property.subscribe(e ->
                result.setValue(mapper.apply(property.getValue()))
        );

        return new FloatExpression(result, Collections.singletonList(subscription));
    }
}

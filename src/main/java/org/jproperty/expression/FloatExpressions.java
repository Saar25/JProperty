package org.jproperty.expression;

import org.jproperty.Subscription;
import org.jproperty.type.ReadOnlyNumberProperty;
import org.jproperty.type.SimpleFloatProperty;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FloatExpressions {

    private FloatExpressions() {
        throw new AssertionError("Cannot create instance of " + getClass().getSimpleName());
    }

    public static FloatExpression add(ReadOnlyNumberProperty first, ReadOnlyNumberProperty second) {
        final SimpleFloatProperty property = new SimpleFloatProperty(first.getFloatValue() + second.getFloatValue());
        final List<Subscription> subscriptions = Arrays.asList(
                first.subscribe(e -> property.set(first.getFloatValue() + second.getFloatValue())),
                second.subscribe(e -> property.set(first.getFloatValue() + second.getFloatValue()))
        );
        return new FloatExpression(property, subscriptions);
    }

    public static FloatExpression add(ReadOnlyNumberProperty first, float second) {
        final SimpleFloatProperty property = new SimpleFloatProperty(first.getFloatValue() + second);
        final List<Subscription> subscriptions = Collections.singletonList(
                first.subscribe(e -> property.set(first.getFloatValue() + second))
        );
        return new FloatExpression(property, subscriptions);
    }

    public static FloatExpression sub(ReadOnlyNumberProperty first, ReadOnlyNumberProperty second) {
        final SimpleFloatProperty property = new SimpleFloatProperty(first.getFloatValue() - second.getFloatValue());
        final List<Subscription> subscriptions = Arrays.asList(
                first.subscribe(e -> property.set(first.getFloatValue() - second.getFloatValue())),
                second.subscribe(e -> property.set(first.getFloatValue() - second.getFloatValue()))
        );
        return new FloatExpression(property, subscriptions);
    }

    public static FloatExpression sub(ReadOnlyNumberProperty first, float second) {
        final SimpleFloatProperty property = new SimpleFloatProperty(first.getFloatValue() - second);
        final List<Subscription> subscriptions = Collections.singletonList(
                first.subscribe(e -> property.set(first.getFloatValue() - second))
        );
        return new FloatExpression(property, subscriptions);
    }

    public static FloatExpression mul(ReadOnlyNumberProperty first, ReadOnlyNumberProperty second) {
        final SimpleFloatProperty property = new SimpleFloatProperty(first.getFloatValue() * second.getFloatValue());
        final List<Subscription> subscriptions = Arrays.asList(
                first.subscribe(e -> property.set(first.getFloatValue() * second.getFloatValue())),
                second.subscribe(e -> property.set(first.getFloatValue() * second.getFloatValue()))
        );
        return new FloatExpression(property, subscriptions);
    }

    public static FloatExpression mul(ReadOnlyNumberProperty first, float second) {
        final SimpleFloatProperty property = new SimpleFloatProperty(first.getFloatValue() * second);
        final List<Subscription> subscriptions = Collections.singletonList(
                first.subscribe(e -> property.set(first.getFloatValue() * second))
        );
        return new FloatExpression(property, subscriptions);
    }

    public static FloatExpression div(ReadOnlyNumberProperty first, ReadOnlyNumberProperty second) {
        final SimpleFloatProperty property = new SimpleFloatProperty(first.getFloatValue() / second.getFloatValue());
        final List<Subscription> subscriptions = Arrays.asList(
                first.subscribe(e -> property.set(first.getFloatValue() / second.getFloatValue())),
                second.subscribe(e -> property.set(first.getFloatValue() / second.getFloatValue()))
        );
        return new FloatExpression(property, subscriptions);
    }

    public static FloatExpression div(ReadOnlyNumberProperty first, float second) {
        final SimpleFloatProperty property = new SimpleFloatProperty(first.getFloatValue() / second);
        final List<Subscription> subscriptions = Collections.singletonList(
                first.subscribe(e -> property.set(first.getFloatValue() / second))
        );
        return new FloatExpression(property, subscriptions);
    }

    public static FloatExpression min(ReadOnlyNumberProperty... properties) {
        final SimpleFloatProperty property = new SimpleFloatProperty(
                Arrays.stream(properties).min((a, b) -> (int) (a.getFloatValue() - b.getFloatValue()))
                        .orElseThrow(AssertionError::new).getFloatValue()
        );

        final List<Subscription> subscriptions = Arrays.stream(properties).map(p -> p.subscribe(e ->
                property.set(Arrays.stream(properties).min((a, b) -> (int) (a.getFloatValue() - b.getFloatValue()))
                        .orElseThrow(AssertionError::new).getFloatValue())
        )).collect(Collectors.toList());

        return new FloatExpression(property, subscriptions);
    }

    public static FloatExpression min(float min, ReadOnlyNumberProperty... properties) {
        final SimpleFloatProperty property = new SimpleFloatProperty(
                Math.min(Arrays.stream(properties).min((a, b) -> (int) (a.getFloatValue() - b.getFloatValue()))
                        .orElseThrow(AssertionError::new).getFloatValue(), min)
        );

        final List<Subscription> subscriptions = Arrays.stream(properties).map(p -> p.subscribe(e ->
                property.set(Math.min(Arrays.stream(properties).min((a, b) -> (int) (a.getFloatValue() - b.getFloatValue()))
                        .orElseThrow(AssertionError::new).getFloatValue(), min))
        )).collect(Collectors.toList());

        return new FloatExpression(property, subscriptions);
    }

    public static FloatExpression max(ReadOnlyNumberProperty... properties) {
        final SimpleFloatProperty property = new SimpleFloatProperty(
                Arrays.stream(properties).max((a, b) -> (int) (a.getFloatValue() - b.getFloatValue()))
                        .orElseThrow(AssertionError::new).getFloatValue()
        );

        final List<Subscription> subscriptions = Arrays.stream(properties).map(p -> p.subscribe(e ->
                property.set(Arrays.stream(properties).max((a, b) -> (int) (a.getFloatValue() - b.getFloatValue()))
                        .orElseThrow(AssertionError::new).getFloatValue())
        )).collect(Collectors.toList());

        return new FloatExpression(property, subscriptions);
    }

    public static FloatExpression max(float max, ReadOnlyNumberProperty... properties) {
        final SimpleFloatProperty property = new SimpleFloatProperty(
                Math.max(Arrays.stream(properties).max((a, b) -> (int) (a.getFloatValue() - b.getFloatValue()))
                        .orElseThrow(AssertionError::new).getFloatValue(), max)
        );

        final List<Subscription> subscriptions = Arrays.stream(properties).map(p -> p.subscribe(e ->
                property.set(Math.max(Arrays.stream(properties).max((a, b) -> (int) (a.getFloatValue() - b.getFloatValue()))
                        .orElseThrow(AssertionError::new).getFloatValue(), max))
        )).collect(Collectors.toList());

        return new FloatExpression(property, subscriptions);
    }
}

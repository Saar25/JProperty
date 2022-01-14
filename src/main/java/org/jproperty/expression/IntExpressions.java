package org.jproperty.expression;

import org.jproperty.Subscription;
import org.jproperty.type.ReadOnlyNumberProperty;
import org.jproperty.type.SimpleIntProperty;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class IntExpressions {

    private IntExpressions() {
        throw new AssertionError("Cannot create instance of " + getClass().getSimpleName());
    }

    public static IntExpression add(ReadOnlyNumberProperty first, ReadOnlyNumberProperty second) {
        final SimpleIntProperty property = new SimpleIntProperty(first.getIntValue() + second.getIntValue());
        final List<Subscription> subscriptions = Arrays.asList(
                first.subscribe(e -> property.set(first.getIntValue() + second.getIntValue())),
                second.subscribe(e -> property.set(first.getIntValue() + second.getIntValue()))
        );
        return new IntExpression(property, subscriptions);
    }

    public static IntExpression add(ReadOnlyNumberProperty first, int second) {
        final SimpleIntProperty property = new SimpleIntProperty(first.getIntValue() + second);
        final List<Subscription> subscriptions = Collections.singletonList(
                first.subscribe(e -> property.set(first.getIntValue() + second))
        );
        return new IntExpression(property, subscriptions);
    }

    public static IntExpression sub(ReadOnlyNumberProperty first, ReadOnlyNumberProperty second) {
        final SimpleIntProperty property = new SimpleIntProperty(first.getIntValue() - second.getIntValue());
        final List<Subscription> subscriptions = Arrays.asList(
                first.subscribe(e -> property.set(first.getIntValue() - second.getIntValue())),
                second.subscribe(e -> property.set(first.getIntValue() - second.getIntValue()))
        );
        return new IntExpression(property, subscriptions);
    }

    public static IntExpression sub(ReadOnlyNumberProperty first, int second) {
        final SimpleIntProperty property = new SimpleIntProperty(first.getIntValue() - second);
        final List<Subscription> subscriptions = Collections.singletonList(
                first.subscribe(e -> property.set(first.getIntValue() - second))
        );
        return new IntExpression(property, subscriptions);
    }

    public static IntExpression mul(ReadOnlyNumberProperty first, ReadOnlyNumberProperty second) {
        final SimpleIntProperty property = new SimpleIntProperty(first.getIntValue() * second.getIntValue());
        final List<Subscription> subscriptions = Arrays.asList(
                first.subscribe(e -> property.set(first.getIntValue() * second.getIntValue())),
                second.subscribe(e -> property.set(first.getIntValue() * second.getIntValue()))
        );
        return new IntExpression(property, subscriptions);
    }

    public static IntExpression mul(ReadOnlyNumberProperty first, int second) {
        final SimpleIntProperty property = new SimpleIntProperty(first.getIntValue() * second);
        final List<Subscription> subscriptions = Collections.singletonList(
                first.subscribe(e -> property.set(first.getIntValue() * second))
        );
        return new IntExpression(property, subscriptions);
    }

    public static IntExpression div(ReadOnlyNumberProperty first, ReadOnlyNumberProperty second) {
        final SimpleIntProperty property = new SimpleIntProperty(first.getIntValue() / second.getIntValue());
        final List<Subscription> subscriptions = Arrays.asList(
                first.subscribe(e -> property.set(first.getIntValue() / second.getIntValue())),
                second.subscribe(e -> property.set(first.getIntValue() / second.getIntValue()))
        );
        return new IntExpression(property, subscriptions);
    }

    public static IntExpression div(ReadOnlyNumberProperty first, int second) {
        final SimpleIntProperty property = new SimpleIntProperty(first.getIntValue() / second);
        final List<Subscription> subscriptions = Collections.singletonList(
                first.subscribe(e -> property.set(first.getIntValue() / second))
        );
        return new IntExpression(property, subscriptions);
    }

    public static IntExpression sum(ReadOnlyNumberProperty... properties) {
        final SimpleIntProperty property = new SimpleIntProperty(
                Arrays.stream(properties).mapToInt(ReadOnlyNumberProperty::getIntValue).sum()
        );

        final List<Subscription> subscriptions = Arrays.stream(properties).map(p -> p.subscribe(e ->
                property.set(Arrays.stream(properties).mapToInt(ReadOnlyNumberProperty::getIntValue).sum())
        )).collect(Collectors.toList());

        return new IntExpression(property, subscriptions);
    }

    public static IntExpression min(ReadOnlyNumberProperty... properties) {
        final SimpleIntProperty property = new SimpleIntProperty(
                Arrays.stream(properties).mapToInt(ReadOnlyNumberProperty::getIntValue).min().orElse(0)
        );

        final List<Subscription> subscriptions = Arrays.stream(properties).map(p -> p.subscribe(e ->
                property.set(Arrays.stream(properties).mapToInt(ReadOnlyNumberProperty::getIntValue).min().orElse(0))
        )).collect(Collectors.toList());

        return new IntExpression(property, subscriptions);
    }

    public static IntExpression min(int min, ReadOnlyNumberProperty... properties) {
        final SimpleIntProperty property = new SimpleIntProperty(
                Math.min(Arrays.stream(properties).mapToInt(ReadOnlyNumberProperty::getIntValue).min().orElse(min), min)
        );

        final List<Subscription> subscriptions = Arrays.stream(properties).map(p -> p.subscribe(e ->
                property.set(Math.min(Arrays.stream(properties).mapToInt(ReadOnlyNumberProperty::getIntValue).min().orElse(min), min))
        )).collect(Collectors.toList());

        return new IntExpression(property, subscriptions);
    }

    public static IntExpression max(ReadOnlyNumberProperty... properties) {
        final SimpleIntProperty property = new SimpleIntProperty(
                Arrays.stream(properties).mapToInt(ReadOnlyNumberProperty::getIntValue).max().orElse(0)
        );

        final List<Subscription> subscriptions = Arrays.stream(properties).map(p -> p.subscribe(e ->
                property.set(Arrays.stream(properties).mapToInt(ReadOnlyNumberProperty::getIntValue).max().orElse(0))
        )).collect(Collectors.toList());

        return new IntExpression(property, subscriptions);
    }

    public static IntExpression max(int max, ReadOnlyNumberProperty... properties) {
        final SimpleIntProperty property = new SimpleIntProperty(
                Math.max(Arrays.stream(properties).mapToInt(ReadOnlyNumberProperty::getIntValue).max().orElse(max), max)
        );

        final List<Subscription> subscriptions = Arrays.stream(properties).map(p -> p.subscribe(e ->
                property.set(Math.max(Arrays.stream(properties).mapToInt(ReadOnlyNumberProperty::getIntValue).max().orElse(max), max))
        )).collect(Collectors.toList());

        return new IntExpression(property, subscriptions);
    }
}

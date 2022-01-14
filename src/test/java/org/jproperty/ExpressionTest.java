package org.jproperty;

import org.jproperty.expression.Expression;
import org.jproperty.expression.Expressions;
import org.jproperty.expression.FloatExpression;
import org.jproperty.expression.IntExpression;
import org.jproperty.type.ObjectProperty;
import org.jproperty.type.SimpleObjectProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExpressionTest {

    private ObjectProperty<String> stringProperty;

    @BeforeEach
    public void init() {
        this.stringProperty = new SimpleObjectProperty<>();
    }

    @Test
    public void testMap() {
        this.stringProperty.setValue("This is a string");

        final Expression<String> expression = Expressions.map(this.stringProperty, s -> s.substring(5));

        Assertions.assertEquals(expression.getValue(), "is a string");
    }

    @Test
    public void testMapUpdates() {
        this.stringProperty.setValue("This is a string");

        final Expression<String> expression = Expressions.map(this.stringProperty, s -> s.substring(5));

        this.stringProperty.setValue("This is another string");

        Assertions.assertEquals(expression.getValue(), "is another string");
    }

    @Test
    public void testMapToInt() {
        this.stringProperty.setValue("This is a string");

        final IntExpression expression = Expressions.mapToInt(this.stringProperty, String::length);

        Assertions.assertEquals(expression.getValue(), 16);
    }

    @Test
    public void testMapToIntUpdates() {
        this.stringProperty.setValue("This is a string");

        final IntExpression expression = Expressions.mapToInt(this.stringProperty, String::length);

        this.stringProperty.setValue("This is another string");

        Assertions.assertEquals(expression.getValue(), 22);
    }

    @Test
    public void testMapToFloat() {
        this.stringProperty.setValue("This is a string");

        final FloatExpression expression = Expressions.mapToFloat(this.stringProperty, s -> s.length() * 3.5f);

        Assertions.assertEquals(expression.getValue(), 56f);
    }

    @Test
    public void testMapToFloatUpdates() {
        this.stringProperty.setValue("This is a string");

        final FloatExpression expression = Expressions.mapToFloat(this.stringProperty, s -> s.length() * 3.5f);

        this.stringProperty.setValue("This is another string");

        Assertions.assertEquals(expression.getValue(), 77f);
    }

    @Test
    public void testChainedMap() {
        this.stringProperty.setValue("This is a string");

        final Expression<String> expression1 = Expressions.map(this.stringProperty, s -> s.substring(0, 5));
        final Expression<String> expression2 = Expressions.map(expression1, s -> s + "isn't a string");
        final IntExpression expression3 = Expressions.mapToInt(expression2, String::length);

        Assertions.assertEquals(expression1.getValue(), "This ");
        Assertions.assertEquals(expression2.getValue(), "This isn't a string");
        Assertions.assertEquals(expression3.getValue(), 19);
    }

    @Test
    public void testChainedMapUpdates() {
        this.stringProperty.setValue("This is a string");

        final Expression<String> expression1 = Expressions.map(this.stringProperty, s -> s.substring(0, 5));
        final Expression<String> expression2 = Expressions.map(expression1, s -> s + "isn't a string");
        final IntExpression expression3 = Expressions.mapToInt(expression2, String::length);

        this.stringProperty.setValue("Make it work");

        Assertions.assertEquals(expression1.getValue(), "Make ");
        Assertions.assertEquals(expression2.getValue(), "Make isn't a string");
        Assertions.assertEquals(expression3.getValue(), 19);
    }
}

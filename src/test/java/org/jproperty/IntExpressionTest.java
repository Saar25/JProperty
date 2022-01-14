package org.jproperty;

import org.jproperty.expression.IntExpression;
import org.jproperty.expression.IntExpressions;
import org.jproperty.type.IntProperty;
import org.jproperty.type.SimpleIntProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntExpressionTest {

    private IntProperty intProperty;
    private IntProperty otherProperty;

    @BeforeEach
    public void init() {
        this.intProperty = new SimpleIntProperty();
        this.otherProperty = new SimpleIntProperty();
    }

    @Test
    public void testAdd() {
        this.intProperty.set(7);
        this.otherProperty.set(3);

        final IntExpression expression = IntExpressions.add(this.intProperty, this.otherProperty);

        Assertions.assertEquals(expression.get(), 7 + 3);
    }

    @Test
    public void testAddUpdates() {
        this.intProperty.set(7);
        this.otherProperty.set(3);

        final IntExpression expression = IntExpressions.add(this.intProperty, this.otherProperty);

        this.intProperty.set(11);

        Assertions.assertEquals(expression.get(), 11 + 3);

        this.otherProperty.set(4);

        Assertions.assertEquals(expression.get(), 11 + 4);
    }

    @Test
    public void testSub() {
        this.intProperty.set(7);
        this.otherProperty.set(3);

        final IntExpression expression = IntExpressions.sub(this.intProperty, this.otherProperty);

        Assertions.assertEquals(expression.get(), 7 - 3);
    }

    @Test
    public void testSubUpdates() {
        this.intProperty.set(7);
        this.otherProperty.set(3);

        final IntExpression expression = IntExpressions.sub(this.intProperty, this.otherProperty);

        this.intProperty.set(11);

        Assertions.assertEquals(expression.get(), 11 - 3);

        this.otherProperty.set(4);

        Assertions.assertEquals(expression.get(), 11 - 4);
    }

    @Test
    public void testMul() {
        this.intProperty.set(7);
        this.otherProperty.set(3);

        final IntExpression expression = IntExpressions.mul(this.intProperty, this.otherProperty);

        Assertions.assertEquals(expression.get(), 7 * 3);
    }

    @Test
    public void testMulUpdates() {
        this.intProperty.set(7);
        this.otherProperty.set(3);

        final IntExpression expression = IntExpressions.mul(this.intProperty, this.otherProperty);

        this.intProperty.set(11);

        Assertions.assertEquals(expression.get(), 11 * 3);

        this.otherProperty.set(4);

        Assertions.assertEquals(expression.get(), 11 * 4);
    }

    @Test
    public void testDiv() {
        this.intProperty.set(7);
        this.otherProperty.set(3);

        final IntExpression expression = IntExpressions.div(this.intProperty, this.otherProperty);

        Assertions.assertEquals(expression.get(), 7 / 3);
    }

    @Test
    public void testDivUpdates() {
        this.intProperty.set(7);
        this.otherProperty.set(3);

        final IntExpression expression = IntExpressions.div(this.intProperty, this.otherProperty);

        this.intProperty.set(11);

        Assertions.assertEquals(expression.get(), 11 / 3);

        this.otherProperty.set(4);

        Assertions.assertEquals(expression.get(), 11 / 4);
    }

    @Test
    public void testMax() {
        this.intProperty.set(7);
        this.otherProperty.set(3);

        final IntExpression expression = IntExpressions.max(this.intProperty, this.otherProperty);

        Assertions.assertEquals(expression.get(), Math.max(7, 3));
    }

    @Test
    public void testMaxUpdates() {
        this.intProperty.set(7);
        this.otherProperty.set(3);

        final IntExpression expression = IntExpressions.max(this.intProperty, this.otherProperty);

        this.intProperty.set(11);

        Assertions.assertEquals(expression.get(), Math.max(11, 3));

        this.otherProperty.set(4);

        Assertions.assertEquals(expression.get(), Math.max(11, 4));
    }

    @Test
    public void testMin() {
        this.intProperty.set(7);
        this.otherProperty.set(3);

        final IntExpression expression = IntExpressions.min(this.intProperty, this.otherProperty);

        Assertions.assertEquals(expression.get(), Math.min(7, 3));
    }

    @Test
    public void testMinUpdates() {
        this.intProperty.set(7);
        this.otherProperty.set(3);

        final IntExpression expression = IntExpressions.min(this.intProperty, this.otherProperty);

        this.intProperty.set(11);

        Assertions.assertEquals(expression.get(), Math.min(11, 3));

        this.otherProperty.set(4);

        Assertions.assertEquals(expression.get(), Math.min(11, 4));
    }
}

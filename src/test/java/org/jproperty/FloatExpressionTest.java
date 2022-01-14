package org.jproperty;

import org.jproperty.expression.FloatExpression;
import org.jproperty.expression.FloatExpressions;
import org.jproperty.type.FloatProperty;
import org.jproperty.type.SimpleFloatProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FloatExpressionTest {

    private FloatProperty floatProperty;
    private FloatProperty otherProperty;

    @BeforeEach
    public void init() {
        this.floatProperty = new SimpleFloatProperty();
        this.otherProperty = new SimpleFloatProperty();
    }

    @Test
    public void testAdd() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatExpression expression = FloatExpressions.add(this.floatProperty, this.otherProperty);

        Assertions.assertEquals(expression.get(), 7f + 3f);
    }

    @Test
    public void testAddUpdates() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatExpression expression = FloatExpressions.add(this.floatProperty, this.otherProperty);

        this.floatProperty.set(11f);

        Assertions.assertEquals(expression.get(), 11f + 3f);

        this.otherProperty.set(4f);

        Assertions.assertEquals(expression.get(), 11f + 4f);
    }

    @Test
    public void testSub() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatExpression expression = FloatExpressions.sub(this.floatProperty, this.otherProperty);

        Assertions.assertEquals(expression.get(), 7f - 3f);
    }

    @Test
    public void testSubUpdates() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatExpression expression = FloatExpressions.sub(this.floatProperty, this.otherProperty);

        this.floatProperty.set(11f);

        Assertions.assertEquals(expression.get(), 11f - 3f);

        this.otherProperty.set(4f);

        Assertions.assertEquals(expression.get(), 11f - 4f);
    }

    @Test
    public void testMul() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatExpression expression = FloatExpressions.mul(this.floatProperty, this.otherProperty);

        Assertions.assertEquals(expression.get(), 7f * 3f);
    }

    @Test
    public void testMulUpdates() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatExpression expression = FloatExpressions.mul(this.floatProperty, this.otherProperty);

        this.floatProperty.set(11f);

        Assertions.assertEquals(expression.get(), 11f * 3f);

        this.otherProperty.set(4f);

        Assertions.assertEquals(expression.get(), 11f * 4f);
    }

    @Test
    public void testDiv() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatExpression expression = FloatExpressions.div(this.floatProperty, this.otherProperty);

        Assertions.assertEquals(expression.get(), 7f / 3f);
    }

    @Test
    public void testDivUpdates() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatExpression expression = FloatExpressions.div(this.floatProperty, this.otherProperty);

        this.floatProperty.set(11f);

        Assertions.assertEquals(expression.get(), 11f / 3f);

        this.otherProperty.set(4f);

        Assertions.assertEquals(expression.get(), 11f / 4f);
    }

    @Test
    public void testMax() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatExpression expression = FloatExpressions.max(this.floatProperty, this.otherProperty);

        Assertions.assertEquals(expression.get(), Math.max(7f, 3f));
    }

    @Test
    public void testMaxUpdates() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatExpression expression = FloatExpressions.max(this.floatProperty, this.otherProperty);

        this.floatProperty.set(11f);

        Assertions.assertEquals(expression.get(), Math.max(11f, 3f));

        this.otherProperty.set(4f);

        Assertions.assertEquals(expression.get(), Math.max(11f, 4f));
    }

    @Test
    public void testMin() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatExpression expression = FloatExpressions.min(this.floatProperty, this.otherProperty);

        Assertions.assertEquals(expression.get(), Math.min(7f, 3f));
    }

    @Test
    public void testMinUpdates() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatExpression expression = FloatExpressions.min(this.floatProperty, this.otherProperty);

        this.floatProperty.set(11f);

        Assertions.assertEquals(expression.get(), Math.min(11f, 3f));

        this.otherProperty.set(4f);

        Assertions.assertEquals(expression.get(), Math.min(11f, 4f));
    }
}

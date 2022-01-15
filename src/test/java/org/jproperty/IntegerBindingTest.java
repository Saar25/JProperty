package org.jproperty;

import org.jproperty.binding.Bindings;
import org.jproperty.binding.IntegerBinding;
import org.jproperty.property.IntegerProperty;
import org.jproperty.property.SimpleIntegerProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntegerBindingTest {

    private IntegerProperty integerProperty;
    private IntegerProperty otherProperty;

    @BeforeEach
    public void init() {
        this.integerProperty = new SimpleIntegerProperty();
        this.otherProperty = new SimpleIntegerProperty();
    }

    @Test
    public void testAdd() {
        this.integerProperty.set(7);
        this.otherProperty.set(3);

        final IntegerBinding expression = Bindings.add(this.integerProperty, this.otherProperty);

        Assertions.assertEquals(expression.get(), 7 + 3);
    }

    @Test
    public void testAddUpdates() {
        this.integerProperty.set(7);
        this.otherProperty.set(3);

        final IntegerBinding expression = Bindings.add(this.integerProperty, this.otherProperty);

        this.integerProperty.set(11);

        Assertions.assertEquals(expression.get(), 11 + 3);

        this.otherProperty.set(4);

        Assertions.assertEquals(expression.get(), 11 + 4);
    }

    @Test
    public void testSub() {
        this.integerProperty.set(7);
        this.otherProperty.set(3);

        final IntegerBinding expression = Bindings.sub(this.integerProperty, this.otherProperty);

        Assertions.assertEquals(expression.get(), 7 - 3);
    }

    @Test
    public void testSubUpdates() {
        this.integerProperty.set(7);
        this.otherProperty.set(3);

        final IntegerBinding expression = Bindings.sub(this.integerProperty, this.otherProperty);

        this.integerProperty.set(11);

        Assertions.assertEquals(expression.get(), 11 - 3);

        this.otherProperty.set(4);

        Assertions.assertEquals(expression.get(), 11 - 4);
    }

    @Test
    public void testMul() {
        this.integerProperty.set(7);
        this.otherProperty.set(3);

        final IntegerBinding expression = Bindings.mul(this.integerProperty, this.otherProperty);

        Assertions.assertEquals(expression.get(), 7 * 3);
    }

    @Test
    public void testMulUpdates() {
        this.integerProperty.set(7);
        this.otherProperty.set(3);

        final IntegerBinding expression = Bindings.mul(this.integerProperty, this.otherProperty);

        this.integerProperty.set(11);

        Assertions.assertEquals(expression.get(), 11 * 3);

        this.otherProperty.set(4);

        Assertions.assertEquals(expression.get(), 11 * 4);
    }

    @Test
    public void testDiv() {
        this.integerProperty.set(7);
        this.otherProperty.set(3);

        final IntegerBinding expression = Bindings.div(this.integerProperty, this.otherProperty);

        Assertions.assertEquals(expression.get(), 7 / 3);
    }

    @Test
    public void testDivUpdates() {
        this.integerProperty.set(7);
        this.otherProperty.set(3);

        final IntegerBinding expression = Bindings.div(this.integerProperty, this.otherProperty);

        this.integerProperty.set(11);

        Assertions.assertEquals(expression.get(), 11 / 3);

        this.otherProperty.set(4);

        Assertions.assertEquals(expression.get(), 11 / 4);
    }


    @Test
    public void testSum() {
        this.integerProperty.set(7);
        this.otherProperty.set(3);

        final IntegerBinding expression = Bindings.sum(this.integerProperty, this.otherProperty);

        Assertions.assertEquals(expression.get(), 7 + 3);
    }

    @Test
    public void testSumUpdates() {
        this.integerProperty.set(7);
        this.otherProperty.set(3);

        final IntegerBinding expression = Bindings.sum(this.integerProperty, this.otherProperty);

        this.integerProperty.set(11);

        Assertions.assertEquals(expression.get(), 11 + 3);

        this.otherProperty.set(4);

        Assertions.assertEquals(expression.get(), 11 + 4f);
    }

    @Test
    public void testMax() {
        this.integerProperty.set(7);
        this.otherProperty.set(3);

        final IntegerBinding expression = Bindings.max(this.integerProperty, this.otherProperty);

        Assertions.assertEquals(expression.get(), Math.max(7, 3));
    }

    @Test
    public void testMaxUpdates() {
        this.integerProperty.set(7);
        this.otherProperty.set(3);

        final IntegerBinding expression = Bindings.max(this.integerProperty, this.otherProperty);

        this.integerProperty.set(11);

        Assertions.assertEquals(expression.get(), Math.max(11, 3));

        this.otherProperty.set(4);

        Assertions.assertEquals(expression.get(), Math.max(11, 4));
    }

    @Test
    public void testMin() {
        this.integerProperty.set(7);
        this.otherProperty.set(3);

        final IntegerBinding expression = Bindings.min(this.integerProperty, this.otherProperty);

        Assertions.assertEquals(expression.get(), Math.min(7, 3));
    }

    @Test
    public void testMinUpdates() {
        this.integerProperty.set(7);
        this.otherProperty.set(3);

        final IntegerBinding expression = Bindings.min(this.integerProperty, this.otherProperty);

        this.integerProperty.set(11);

        Assertions.assertEquals(expression.get(), Math.min(11, 3));

        this.otherProperty.set(4);

        Assertions.assertEquals(expression.get(), Math.min(11, 4));
    }
}

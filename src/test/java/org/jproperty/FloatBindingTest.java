package org.jproperty;

import org.jproperty.binding.Bindings;
import org.jproperty.binding.FloatBinding;
import org.jproperty.property.FloatProperty;
import org.jproperty.property.SimpleFloatProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FloatBindingTest {

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

        final FloatBinding expression = Bindings.add(this.floatProperty, this.otherProperty);

        Assertions.assertEquals(7f + 3f, expression.get());
    }

    @Test
    public void testAddUpdates() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatBinding expression = Bindings.add(this.floatProperty, this.otherProperty);

        this.floatProperty.set(11f);

        Assertions.assertEquals(11f + 3f, expression.get());

        this.otherProperty.set(4f);

        Assertions.assertEquals(11f + 4f, expression.get());
    }

    @Test
    public void testSub() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatBinding expression = Bindings.sub(this.floatProperty, this.otherProperty);

        Assertions.assertEquals(7f - 3f, expression.get());
    }

    @Test
    public void testSubUpdates() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatBinding expression = Bindings.sub(this.floatProperty, this.otherProperty);

        this.floatProperty.set(11f);

        Assertions.assertEquals(11f - 3f, expression.get());

        this.otherProperty.set(4f);

        Assertions.assertEquals(11f - 4f, expression.get());
    }

    @Test
    public void testMul() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatBinding expression = Bindings.mul(this.floatProperty, this.otherProperty);

        Assertions.assertEquals(7f * 3f, expression.get());
    }

    @Test
    public void testMulUpdates() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatBinding expression = Bindings.mul(this.floatProperty, this.otherProperty);

        this.floatProperty.set(11f);

        Assertions.assertEquals(11f * 3f, expression.get());

        this.otherProperty.set(4f);

        Assertions.assertEquals(11f * 4f, expression.get());
    }

    @Test
    public void testDiv() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatBinding expression = Bindings.div(this.floatProperty, this.otherProperty);

        Assertions.assertEquals(7f / 3f, expression.get());
    }

    @Test
    public void testDivUpdates() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatBinding expression = Bindings.div(this.floatProperty, this.otherProperty);

        this.floatProperty.set(11f);

        Assertions.assertEquals(11f / 3f, expression.get());

        this.otherProperty.set(4f);

        Assertions.assertEquals(11f / 4f, expression.get());
    }

    @Test
    public void testSum() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatBinding expression = Bindings.sum(this.floatProperty, this.otherProperty);

        Assertions.assertEquals(7f + 3f, expression.get());
    }

    @Test
    public void testSumUpdates() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatBinding expression = Bindings.sum(this.floatProperty, this.otherProperty);

        this.floatProperty.set(11f);

        Assertions.assertEquals(11f + 3f, expression.get());

        this.otherProperty.set(4f);

        Assertions.assertEquals(11f + 4f, expression.get());
    }

    @Test
    public void testMax() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatBinding expression = Bindings.max(this.floatProperty, this.otherProperty);

        Assertions.assertEquals(Math.max(7f, 3f), expression.get());
    }

    @Test
    public void testMaxUpdates() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatBinding expression = Bindings.max(this.floatProperty, this.otherProperty);

        this.floatProperty.set(11f);

        Assertions.assertEquals(Math.max(11f, 3f), expression.get());

        this.otherProperty.set(4f);

        Assertions.assertEquals(Math.max(11f, 4f), expression.get());
    }

    @Test
    public void testMin() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatBinding expression = Bindings.min(this.floatProperty, this.otherProperty);

        Assertions.assertEquals(Math.min(7f, 3f), expression.get());
    }

    @Test
    public void testMinUpdates() {
        this.floatProperty.set(7f);
        this.otherProperty.set(3f);

        final FloatBinding expression = Bindings.min(this.floatProperty, this.otherProperty);

        this.floatProperty.set(11f);

        Assertions.assertEquals(Math.min(11f, 3f), expression.get());

        this.otherProperty.set(4f);

        Assertions.assertEquals(Math.min(11f, 4f), expression.get());
    }
}

package org.jproperty;

import org.jproperty.type.IntProperty;
import org.jproperty.type.SimpleIntProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntPropertyTest {

    private IntProperty intProperty;
    private IntProperty otherProperty;

    @BeforeEach
    public void initProperty() {
        this.intProperty = new SimpleIntProperty();
        this.otherProperty = new SimpleIntProperty();
    }

    @Test
    public void testDirectionalBinding() {
        this.intProperty.set(10);
        this.otherProperty.set(5);

        this.intProperty.bind(this.otherProperty);

        Assertions.assertTrue(this.intProperty.isBound());

        Assertions.assertEquals(this.intProperty.get(), 5);

        this.intProperty.set(2);

        Assertions.assertEquals(this.intProperty.get(), 5);
    }

    @Test
    public void testBidirectionalBinding() {
        this.intProperty.set(10);
        this.otherProperty.set(5);

        this.intProperty.bindBidirectional(this.otherProperty);

        Assertions.assertEquals(this.intProperty.get(), 5);
        Assertions.assertEquals(this.otherProperty.get(), 5);

        Assertions.assertTrue(this.intProperty.isBound());
        Assertions.assertTrue(this.otherProperty.isBound());

        this.otherProperty.set(2);

        Assertions.assertEquals(this.intProperty.get(), 2);

        this.intProperty.set(7);

        Assertions.assertEquals(this.otherProperty.get(), 7);
    }

    @Test
    public void testDirectionalUnbinding() {
        this.intProperty.set(10);
        this.otherProperty.set(5);

        this.intProperty.bind(this.otherProperty);

        this.intProperty.unbind();

        this.intProperty.set(2);

        Assertions.assertFalse(this.intProperty.isBound());

        Assertions.assertEquals(this.intProperty.get(), 2);
    }

    @Test
    public void testBidirectionalUnbinding() {
        this.intProperty.set(10);
        this.otherProperty.set(5);

        this.intProperty.bindBidirectional(this.otherProperty);

        this.otherProperty.set(2);

        Assertions.assertEquals(this.intProperty.get(), 2);
        Assertions.assertEquals(this.otherProperty.get(), 2);

        this.intProperty.unbindBidirectional(this.otherProperty);

        this.intProperty.set(7);

        Assertions.assertEquals(this.intProperty.get(), 7);
        Assertions.assertEquals(this.otherProperty.get(), 2);
    }
}

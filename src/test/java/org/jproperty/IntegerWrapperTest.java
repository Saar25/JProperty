package org.jproperty;

import org.jproperty.binding.IntegerWrapper;
import org.jproperty.property.IntegerProperty;
import org.jproperty.property.SimpleIntegerProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntegerWrapperTest {

    private IntegerProperty integerProperty;
    private IntegerProperty otherProperty;

    @BeforeEach
    public void init() {
        this.integerProperty = new SimpleIntegerProperty();
        this.otherProperty = new SimpleIntegerProperty();
    }

    @Test
    public void testWrap() {
        this.integerProperty.set(7);
        this.otherProperty.set(3);

        final IntegerWrapper wrapper = new IntegerWrapper(this.integerProperty);

        Assertions.assertEquals(wrapper.getIntValue(), 7);
    }

    @Test
    public void testWrapUpdates() {
        this.integerProperty.set(7);

        final IntegerWrapper wrapper = new IntegerWrapper(this.integerProperty);

        Assertions.assertEquals(wrapper.getIntValue(), 7);

        this.integerProperty.set(3);

        Assertions.assertEquals(wrapper.getIntValue(), 3);
    }

    @Test
    public void testSettingWrap() {
        this.integerProperty.set(7);
        this.otherProperty.set(3);

        final IntegerWrapper wrapper = new IntegerWrapper(this.integerProperty);

        Assertions.assertEquals(wrapper.getIntValue(), 7);

        wrapper.set(this.otherProperty);

        this.integerProperty.set(10);

        Assertions.assertEquals(wrapper.getIntValue(), 3);
    }
}

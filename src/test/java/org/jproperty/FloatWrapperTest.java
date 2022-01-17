package org.jproperty;

import org.jproperty.binding.FloatWrapper;
import org.jproperty.property.FloatProperty;
import org.jproperty.property.SimpleFloatProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FloatWrapperTest {

    private FloatProperty floatProperty;
    private FloatProperty otherProperty;

    @BeforeEach
    public void init() {
        this.floatProperty = new SimpleFloatProperty();
        this.otherProperty = new SimpleFloatProperty();
    }

    @Test
    public void testWrap() {
        this.floatProperty.set(7);
        this.otherProperty.set(3);

        final FloatWrapper wrapper = new FloatWrapper(this.floatProperty);

        Assertions.assertEquals(wrapper.getIntValue(), 7);
    }

    @Test
    public void testWrapUpdates() {
        this.floatProperty.set(7);

        final FloatWrapper wrapper = new FloatWrapper(this.floatProperty);

        Assertions.assertEquals(wrapper.getIntValue(), 7);

        this.floatProperty.set(3);

        Assertions.assertEquals(wrapper.getIntValue(), 3);
    }

    @Test
    public void testSettingWrap() {
        this.floatProperty.set(7);
        this.otherProperty.set(3);

        final FloatWrapper wrapper = new FloatWrapper(this.floatProperty);

        Assertions.assertEquals(wrapper.getIntValue(), 7);

        wrapper.set(this.otherProperty);

        this.floatProperty.set(10);

        Assertions.assertEquals(wrapper.getIntValue(), 3);
    }
}

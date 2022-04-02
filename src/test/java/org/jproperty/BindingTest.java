package org.jproperty;

import org.jproperty.binding.Bindings;
import org.jproperty.binding.FloatBinding;
import org.jproperty.binding.IntegerBinding;
import org.jproperty.binding.ObjectBinding;
import org.jproperty.property.ObjectProperty;
import org.jproperty.property.SimpleObjectProperty;
import org.jproperty.value.ObservableFloatValue;
import org.jproperty.value.ObservableIntegerValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BindingTest {

    private ObjectProperty<String> stringProperty;
    private ObjectProperty<String> otherProperty;

    @BeforeEach
    public void init() {
        this.stringProperty = new SimpleObjectProperty<>();
        this.otherProperty = new SimpleObjectProperty<>();
    }

    @Test
    public void testMap() {
        this.stringProperty.setValue("This is a string");

        final Binding<String> expression = Bindings.map(this.stringProperty, s -> s.substring(5));

        Assertions.assertEquals(expression.getValue(), "is a string");
    }

    @Test
    public void testMapUpdates() {
        this.stringProperty.setValue("This is a string");

        final Binding<String> expression = Bindings.map(this.stringProperty, s -> s.substring(5));

        Assertions.assertEquals(expression.getValue(), "is a string");

        this.stringProperty.setValue("This is another string");

        Assertions.assertEquals(expression.getValue(), "is another string");
    }

    @Test
    public void testMapToInt() {
        this.stringProperty.setValue("This is a string");

        final IntegerBinding expression = Bindings.mapToInt(this.stringProperty, String::length);

        Assertions.assertEquals(expression.getValue(), 16);
    }

    @Test
    public void testMapToIntUpdates() {
        this.stringProperty.setValue("This is a string");

        final IntegerBinding expression = Bindings.mapToInt(this.stringProperty, String::length);

        this.stringProperty.setValue("This is another string");

        Assertions.assertEquals(expression.getValue(), 22);
    }

    @Test
    public void testMapToFloat() {
        this.stringProperty.setValue("This is a string");

        final FloatBinding expression = Bindings.mapToFloat(this.stringProperty, s -> s.length() * 3.5f);

        Assertions.assertEquals(expression.getValue(), 56f);
    }

    @Test
    public void testMapToFloatUpdates() {
        this.stringProperty.setValue("This is a string");

        final FloatBinding expression = Bindings.mapToFloat(this.stringProperty, s -> s.length() * 3.5f);

        this.stringProperty.setValue("This is another string");

        Assertions.assertEquals(expression.getValue(), 77f);
    }

    @Test
    public void testChainedMap() {
        this.stringProperty.setValue("This is a string");

        final Binding<String> expression1 = Bindings.map(this.stringProperty, s -> s.substring(0, 5));
        final Binding<String> expression2 = Bindings.map(expression1, s -> s + "isn't a string");
        final IntegerBinding expression3 = Bindings.mapToInt(expression2, String::length);

        Assertions.assertEquals(expression1.getValue(), "This ");
        Assertions.assertEquals(expression2.getValue(), "This isn't a string");
        Assertions.assertEquals(expression3.getValue(), 19);
    }

    @Test
    public void testChainedMapUpdates() {
        this.stringProperty.setValue("This is a string");

        final Binding<String> expression1 = Bindings.map(this.stringProperty, s -> s.substring(0, 5));
        final Binding<String> expression2 = Bindings.map(expression1, s -> s + "isn't a string");
        final IntegerBinding expression3 = Bindings.mapToInt(expression2, String::length);

        this.stringProperty.setValue("Make it work");

        Assertions.assertEquals(expression1.getValue(), "Make ");
        Assertions.assertEquals(expression2.getValue(), "Make isn't a string");
        Assertions.assertEquals(expression3.getValue(), 19);
    }

    @Test
    public void testFlatMap() {
        this.stringProperty.setValue("This is a string");
        this.otherProperty.setValue("This is another string");

        final ObjectBinding<String> binding = Bindings.flatMap(this.stringProperty, v -> this.otherProperty);

        Assertions.assertEquals(binding.getValue(), "This is another string");
    }

    @Test
    public void testFlatMapUpdates() {
        this.stringProperty.setValue("This is a string");
        this.otherProperty.setValue("This is another string");

        final ObjectBinding<String> binding = Bindings.flatMap(this.stringProperty, v -> this.otherProperty);

        this.otherProperty.set("Hello world");

        Assertions.assertEquals(binding.getValue(), "Hello world");
    }

    @Test
    public void testFlatMapToInteger() {
        this.stringProperty.setValue("This is a string");
        this.otherProperty.setValue("This is another string");

        final ObservableIntegerValue otherLength = Bindings.mapToInt(this.otherProperty, String::length);

        final ObservableIntegerValue binding = Bindings.flatMapToInteger(this.stringProperty, v -> otherLength);

        Assertions.assertEquals(binding.getValue(), "This is another string".length());
    }

    @Test
    public void testFlatMapToIntegerUpdates() {
        this.stringProperty.setValue("This is a string");
        this.otherProperty.setValue("This is another string");

        final ObservableIntegerValue otherLength = Bindings.mapToInt(this.otherProperty, String::length);

        final ObservableIntegerValue binding = Bindings.flatMapToInteger(this.stringProperty, v -> otherLength);

        this.otherProperty.set("Hello world");

        Assertions.assertEquals(binding.getValue(), "Hello world".length());
    }

    @Test
    public void testFlatMapToFloat() {
        this.stringProperty.setValue("This is a string");
        this.otherProperty.setValue("This is another string");

        final ObservableFloatValue otherLength = Bindings.mapToFloat(this.otherProperty, a -> 5.5f);

        final ObservableFloatValue binding = Bindings.flatMapToFloat(this.stringProperty, v -> otherLength);

        Assertions.assertEquals(binding.getValue(), 5.5f);
    }

    @Test
    public void testFlatMapToFloatUpdates() {
        this.stringProperty.setValue("This is a string");
        this.otherProperty.setValue("This is another string");

        final ObservableFloatValue otherLength = Bindings.mapToFloat(this.otherProperty, v -> 5.5f);

        final ObservableFloatValue binding = Bindings.flatMapToFloat(this.stringProperty, v -> otherLength);

        this.otherProperty.set("Hello world");

        Assertions.assertEquals(binding.getValue(), 5.5f);
    }
}

# JProperty
Java utility library that provides properties, like JavaFX but simplified

## Using JProperty with maven
```xml
<dependency>
    <groupId>com.github.saar25</groupId>
    <artifactId>jproperty</artifactId>
    <version>1.0.1</version>
</dependency>
```

## Examples

#### Wrapping java primitives and objects.

```java
final IntProperty intProperty = new SimpleIntProperty(8);
final FloatProperty floatProperty = new SimpleFloatProperty(1.7f);
final ObjectProperty<Object> objectProperty = new SimpleObjectProperty<>(new Object());

final ReadOnlyIntProperty readOnlyIntProperty = new SimpleIntProperty();
final ReadOnlyFloatProperty readOnlyFloatProperty = new SimpleFloatProperty();
```
#### Listening to value changes
```java
intProperty.addListener(e -> {
    System.out.println("Changed" +
            " from " + e.getOldValue() +
            " to " + e.getNewValue());
});
intProperty.set(5); // Prints output
intProperty.set(5); // Does not print output
intProperty.set(1); // Prints output
```
#### Binding properties to one another
```java
System.out.println(intProperty.get()); // 8
System.out.println(floatProperty.get()); // 1.7f

intProperty.bind(floatProperty)
System.out.println(intProperty.get()); // 1

floatProperty.set(9.4f)
System.out.println(intProperty.get()); // 9
```
#### Bidirectional binding
```java
System.out.println(intProperty.get()); // 8
System.out.println(floatProperty.get()); // 1.7

intProperty.bindBidirectional(floatProperty);
System.out.println(intProperty.get()); // 1
System.out.println(floatProperty.get()); // 1.7

floatProperty.set(4f);
System.out.println(intProperty.get()); // 4
System.out.println(floatProperty.get()); // 4.0

intProperty.set(17);
System.out.println(intProperty.get()); // 17 
System.out.println(floatProperty.get()); // 17.0
```
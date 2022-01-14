# JProperty
Java utility library that provides properties, like JavaFX but simplified

## Using JProperty with maven
```xml
<dependency>
    <groupId>com.github.saar25</groupId>
    <artifactId>jproperty</artifactId>
    <version>1.1.0</version>
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
#### Building up expressions
```java
final IntProperty aProperty = new SimpleIntProperty(8);
final IntProperty bProperty = new SimpleIntProperty(3);

final IntExpression expression = IntExpressions.add(aProperty, bProperty);

System.out.println(a.get()) // Prints 11
```
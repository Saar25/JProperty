package org.jproperty.type;

public class ConstantIntProperty extends ConstantNumberPropertyBase implements ReadOnlyIntProperty {

    private final int value;

    public ConstantIntProperty(int value) {
        this.value = value;
    }

    @Override
    public int get() {
        return this.value;
    }

    @Override
    public Integer getValue() {
        return get();
    }

    @Override
    public String toString() {
        return "ConstantIntProperty{" + get() + '}';
    }
}

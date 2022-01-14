package org.jproperty.type;

public class ConstantFloatProperty extends ConstantNumberPropertyBase implements ReadOnlyFloatProperty {

    private final float value;

    public ConstantFloatProperty(float value) {
        this.value = value;
    }

    @Override
    public float get() {
        return this.value;
    }

    @Override
    public String toString() {
        return "ConstantFloatProperty{" + get() + '}';
    }
}

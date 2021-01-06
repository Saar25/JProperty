package org.jproperty.type;

public class ConstantBooleanProperty extends ConstantPropertyBase<Boolean> implements ReadOnlyBooleanProperty {

    private final boolean value;

    public ConstantBooleanProperty(boolean value) {
        this.value = value;
    }

    @Override
    public boolean get() {
        return this.value;
    }

    @Override
    public Boolean getValue() {
        return get();
    }

    @Override
    public String toString() {
        return "ConstantBooleanProperty{" + get() + '}';
    }
}

package org.jproperty.property;

public class SimpleIntProperty extends NumberPropertyBase implements IntProperty {

    private int value;

    public SimpleIntProperty() {
    }

    public SimpleIntProperty(int value) {
        this.value = value;
    }

    @Override
    public int get() {
        return this.value;
    }

    @Override
    public void set(int value) {
        if (get() != value) {
            int oldValue = this.value;
            this.value = value;

            fireChangeEvent(oldValue);
        }
    }

    @Override
    public String toString() {
        return "SimpleIntProperty{" + get() + '}';
    }
}

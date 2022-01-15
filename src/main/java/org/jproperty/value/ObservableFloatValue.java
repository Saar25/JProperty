package org.jproperty.value;

public interface ObservableFloatValue extends ObservableNumberValue {

    @Override
    default Number getValue() {
        return get();
    }

    @Override
    default float getFloatValue() {
        return get();
    }

    float get();

}

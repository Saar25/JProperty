package org.jproperty.value;

public interface ObservableIntegerValue extends ObservableNumberValue {

    @Override
    default Number getValue() {
        return get();
    }

    @Override
    default int getIntValue() {
        return get();
    }

    int get();

}

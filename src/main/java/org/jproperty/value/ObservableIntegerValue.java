package org.jproperty.value;

public interface ObservableIntegerValue extends ObservableNumberValue {

    @Override
    default Number getValue() {
        return get();
    }

    @Override
    default byte getByteValue() {
        return (byte) get();
    }

    @Override
    default int getIntValue() {
        return get();
    }

    @Override
    default float getFloatValue() {
        return get();
    }

    @Override
    default long getLongValue() {
        return get();
    }

    @Override
    default double getDoubleValue() {
        return get();
    }

    int get();

}

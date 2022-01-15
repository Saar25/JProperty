package org.jproperty.value;

public interface ObservableFloatValue extends ObservableNumberValue {

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
        return (int) get();
    }

    @Override
    default float getFloatValue() {
        return get();
    }

    @Override
    default long getLongValue() {
        return (long) get();
    }

    @Override
    default double getDoubleValue() {
        return get();
    }

    float get();

}

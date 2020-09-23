package org.jproperty.type;

public interface ReadOnlyIntProperty extends ReadOnlyNumberProperty {

    @Override
    Integer getValue();

    int get();

}

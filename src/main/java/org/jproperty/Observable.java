package org.jproperty;

public interface Observable {

    void addListener(InvalidationListener listener);

    void removeListener(InvalidationListener listener);

}

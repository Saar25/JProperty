package org.jproperty;

@FunctionalInterface
public interface InvalidationListener {

    void onInvalidation(Observable observable);

}

package org.jproperty.binding;

import org.jproperty.Binding;
import org.jproperty.InvalidationListener;
import org.jproperty.Observable;

import java.lang.ref.WeakReference;

public class InvalidationObserver implements InvalidationListener {

    private final WeakReference<Binding<?>> reference;

    public InvalidationObserver(Binding<?> binding) {
        this.reference = new WeakReference<>(binding);
    }

    @Override
    public void onInvalidation(Observable observable) {
        final Binding<?> binding = this.reference.get();
        if (binding == null) {
            observable.removeListener(this);
        } else {
            binding.invalidate();
        }
    }
}

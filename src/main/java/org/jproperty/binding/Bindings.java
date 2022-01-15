package org.jproperty.binding;

import org.jproperty.value.ObservableFloatValue;
import org.jproperty.value.ObservableIntegerValue;

public final class Bindings {

    public Bindings() {
        throw new AssertionError("Cannot create instance of " +
                getClass().getSimpleName());
    }

    public static IntBinding add(ObservableIntegerValue a, ObservableIntegerValue b) {
        return new IntBinding(a, b) {
            @Override
            protected int compute() {
                return a.get() + b.get();
            }
        };
    }

    public static IntBinding sub(ObservableIntegerValue a, ObservableIntegerValue b) {
        return new IntBinding(a, b) {
            @Override
            protected int compute() {
                return a.get() + b.get();
            }
        };
    }

    public static IntBinding mul(ObservableIntegerValue a, ObservableIntegerValue b) {
        return new IntBinding(a, b) {
            @Override
            protected int compute() {
                return a.get() * b.get();
            }
        };
    }

    public static IntBinding div(ObservableIntegerValue a, ObservableIntegerValue b) {
        return new IntBinding(a, b) {
            @Override
            protected int compute() {
                return a.get() / b.get();
            }
        };
    }

    public static IntBinding sum(ObservableIntegerValue... values) {
        return new IntBinding(values) {
            @Override
            protected int compute() {
                int sum = 0;
                for (ObservableIntegerValue value : values) {
                    sum += value.get();
                }
                return sum;
            }
        };
    }

    public static IntBinding max(ObservableIntegerValue... values) {
        return new IntBinding(values) {
            @Override
            protected int compute() {
                int max = 0;
                for (ObservableIntegerValue value : values) {
                    max = Math.max(max, value.get());
                }
                return max;
            }
        };
    }

    public static IntBinding min(ObservableIntegerValue... values) {
        return new IntBinding(values) {
            @Override
            protected int compute() {
                int min = 0;
                for (ObservableIntegerValue value : values) {
                    min = Math.min(min, value.get());
                }
                return min;
            }
        };
    }

    public static FloatBinding add(ObservableFloatValue a, ObservableFloatValue b) {
        return new FloatBinding(a, b) {
            @Override
            protected float compute() {
                return a.get() + b.get();
            }
        };
    }

    public static FloatBinding sub(ObservableFloatValue a, ObservableFloatValue b) {
        return new FloatBinding(a, b) {
            @Override
            protected float compute() {
                return a.get() + b.get();
            }
        };
    }

    public static FloatBinding mul(ObservableFloatValue a, ObservableFloatValue b) {
        return new FloatBinding(a, b) {
            @Override
            protected float compute() {
                return a.get() * b.get();
            }
        };
    }

    public static FloatBinding div(ObservableFloatValue a, ObservableFloatValue b) {
        return new FloatBinding(a, b) {
            @Override
            protected float compute() {
                return a.get() / b.get();
            }
        };
    }

    public static FloatBinding sum(ObservableFloatValue... values) {
        return new FloatBinding(values) {
            @Override
            protected float compute() {
                float sum = 0;
                for (ObservableFloatValue value : values) {
                    sum += value.get();
                }
                return sum;
            }
        };
    }

    public static FloatBinding max(ObservableFloatValue... values) {
        return new FloatBinding(values) {
            @Override
            protected float compute() {
                float max = 0;
                for (ObservableFloatValue value : values) {
                    max = Math.max(max, value.get());
                }
                return max;
            }
        };
    }

    public static FloatBinding min(ObservableFloatValue... values) {
        return new FloatBinding(values) {
            @Override
            protected float compute() {
                float min = 0;
                for (ObservableFloatValue value : values) {
                    min = Math.min(min, value.get());
                }
                return min;
            }
        };
    }
}

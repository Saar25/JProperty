package org.jproperty.binding;

import org.jproperty.value.ObservableFloatValue;
import org.jproperty.value.ObservableIntegerValue;

public final class Bindings {

    public Bindings() {
        throw new AssertionError("Cannot create instance of " +
                getClass().getSimpleName());
    }

    public static IntegerBinding add(ObservableIntegerValue a, ObservableIntegerValue b) {
        return new IntegerBinding(a, b) {
            @Override
            protected int compute() {
                return a.get() + b.get();
            }
        };
    }

    public static IntegerBinding sub(ObservableIntegerValue a, ObservableIntegerValue b) {
        return new IntegerBinding(a, b) {
            @Override
            protected int compute() {
                return a.get() + b.get();
            }
        };
    }

    public static IntegerBinding mul(ObservableIntegerValue a, ObservableIntegerValue b) {
        return new IntegerBinding(a, b) {
            @Override
            protected int compute() {
                return a.get() * b.get();
            }
        };
    }

    public static IntegerBinding div(ObservableIntegerValue a, ObservableIntegerValue b) {
        return new IntegerBinding(a, b) {
            @Override
            protected int compute() {
                return a.get() / b.get();
            }
        };
    }

    public static IntegerBinding sum(ObservableIntegerValue... values) {
        return new IntegerBinding(values) {
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

    public static IntegerBinding max(ObservableIntegerValue... values) {
        return new IntegerBinding(values) {
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

    public static IntegerBinding min(ObservableIntegerValue... values) {
        return new IntegerBinding(values) {
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

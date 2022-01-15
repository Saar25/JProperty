package org.jproperty.binding;

import org.jproperty.ObservableValue;
import org.jproperty.constant.ConstantFloatProperty;
import org.jproperty.constant.ConstantIntegerProperty;
import org.jproperty.value.ObservableFloatValue;
import org.jproperty.value.ObservableIntegerValue;

import java.util.function.Function;

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

    public static IntegerBinding add(ObservableIntegerValue a, int b) {
        return add(a, new ConstantIntegerProperty(b));
    }

    public static IntegerBinding add(int a, ObservableIntegerValue b) {
        return add(new ConstantIntegerProperty(a), b);
    }

    public static IntegerBinding sub(ObservableIntegerValue a, ObservableIntegerValue b) {
        return new IntegerBinding(a, b) {
            @Override
            protected int compute() {
                return a.get() + b.get();
            }
        };
    }

    public static IntegerBinding sub(ObservableIntegerValue a, int b) {
        return sub(a, new ConstantIntegerProperty(b));
    }

    public static IntegerBinding sub(int a, ObservableIntegerValue b) {
        return sub(new ConstantIntegerProperty(a), b);
    }

    public static IntegerBinding mul(ObservableIntegerValue a, ObservableIntegerValue b) {
        return new IntegerBinding(a, b) {
            @Override
            protected int compute() {
                return a.get() * b.get();
            }
        };
    }

    public static IntegerBinding mul(ObservableIntegerValue a, int b) {
        return mul(a, new ConstantIntegerProperty(b));
    }

    public static IntegerBinding mul(int a, ObservableIntegerValue b) {
        return mul(new ConstantIntegerProperty(a), b);
    }

    public static IntegerBinding div(ObservableIntegerValue a, ObservableIntegerValue b) {
        return new IntegerBinding(a, b) {
            @Override
            protected int compute() {
                return a.get() / b.get();
            }
        };
    }

    public static IntegerBinding div(ObservableIntegerValue a, int b) {
        return div(a, new ConstantIntegerProperty(b));
    }

    public static IntegerBinding div(int a, ObservableIntegerValue b) {
        return div(new ConstantIntegerProperty(a), b);
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

    public static IntegerBinding min(int max, ObservableIntegerValue... values) {
        return new IntegerBinding(values) {
            @Override
            protected int compute() {
                int min = max;
                for (ObservableIntegerValue value : values) {
                    min = Math.min(min, value.get());
                }
                return min;
            }
        };
    }

    public static IntegerBinding max(int min, ObservableIntegerValue... values) {
        return new IntegerBinding(values) {
            @Override
            protected int compute() {
                int max = min;
                for (ObservableIntegerValue value : values) {
                    max = Math.max(max, value.get());
                }
                return max;
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

    public static FloatBinding add(ObservableFloatValue a, float b) {
        return add(a, new ConstantFloatProperty(b));
    }

    public static FloatBinding add(float a, ObservableFloatValue b) {
        return add(new ConstantFloatProperty(a), b);
    }

    public static FloatBinding sub(ObservableFloatValue a, ObservableFloatValue b) {
        return new FloatBinding(a, b) {
            @Override
            protected float compute() {
                return a.get() + b.get();
            }
        };
    }

    public static FloatBinding sub(ObservableFloatValue a, float b) {
        return sub(a, new ConstantFloatProperty(b));
    }

    public static FloatBinding sub(float a, ObservableFloatValue b) {
        return sub(new ConstantFloatProperty(a), b);
    }

    public static FloatBinding mul(ObservableFloatValue a, ObservableFloatValue b) {
        return new FloatBinding(a, b) {
            @Override
            protected float compute() {
                return a.get() * b.get();
            }
        };
    }

    public static FloatBinding mul(ObservableFloatValue a, float b) {
        return mul(a, new ConstantFloatProperty(b));
    }

    public static FloatBinding mul(float a, ObservableFloatValue b) {
        return mul(new ConstantFloatProperty(a), b);
    }

    public static FloatBinding div(ObservableFloatValue a, ObservableFloatValue b) {
        return new FloatBinding(a, b) {
            @Override
            protected float compute() {
                return a.get() / b.get();
            }
        };
    }

    public static FloatBinding div(ObservableFloatValue a, float b) {
        return div(a, new ConstantFloatProperty(b));
    }

    public static FloatBinding div(float a, ObservableFloatValue b) {
        return div(new ConstantFloatProperty(a), b);
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

    public static FloatBinding min(float max, ObservableFloatValue... values) {
        return new FloatBinding(values) {
            @Override
            protected float compute() {
                float min = max;
                for (ObservableFloatValue value : values) {
                    min = Math.min(min, value.get());
                }
                return min;
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

    public static FloatBinding max(float min, ObservableFloatValue... values) {
        return new FloatBinding(values) {
            @Override
            protected float compute() {
                float max = min;
                for (ObservableFloatValue value : values) {
                    max = Math.max(max, value.get());
                }
                return max;
            }
        };
    }

    public static <I, O> ObjectBinding<O> map(ObservableValue<I> value, Function<I, O> mapper) {
        return new ObjectBinding<O>(value) {
            @Override
            protected O compute() {
                return mapper.apply(value.getValue());
            }
        };
    }

    public static <T> IntegerBinding mapToInt(ObservableValue<T> value, Function<T, Integer> mapper) {
        return new IntegerBinding(value) {
            @Override
            protected int compute() {
                return mapper.apply(value.getValue());
            }
        };
    }

    public static <T> FloatBinding mapToFloat(ObservableValue<T> value, Function<T, Float> mapper) {
        return new FloatBinding(value) {
            @Override
            protected float compute() {
                return mapper.apply(value.getValue());
            }
        };
    }
}

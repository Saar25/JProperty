package org.jproperty.binding;

import org.jproperty.ObservableValue;
import org.jproperty.constant.ConstantFloat;
import org.jproperty.constant.ConstantInteger;
import org.jproperty.value.ObservableFloatValue;
import org.jproperty.value.ObservableIntegerValue;

import java.util.function.Function;

public final class Bindings {

    public Bindings() {
        throw new AssertionError("Cannot create instance of " +
                getClass().getSimpleName());
    }

    public static IntegerBinding add(ObservableIntegerValue a, ObservableIntegerValue b) {
        return new IntegerBinding() {
            {
                bind(a, b);
            }

            @Override
            protected int compute() {
                return a.get() + b.get();
            }

            @Override
            public void dispose() {
                unbind(a, b);
            }
        };
    }

    public static IntegerBinding add(ObservableIntegerValue a, int b) {
        return add(a, new ConstantInteger(b));
    }

    public static IntegerBinding add(int a, ObservableIntegerValue b) {
        return add(new ConstantInteger(a), b);
    }

    public static IntegerBinding sub(ObservableIntegerValue a, ObservableIntegerValue b) {
        return new IntegerBinding() {
            {
                bind(a, b);
            }

            @Override
            protected int compute() {
                return a.get() - b.get();
            }

            @Override
            public void dispose() {
                unbind(a, b);
            }
        };
    }

    public static IntegerBinding sub(ObservableIntegerValue a, int b) {
        return sub(a, new ConstantInteger(b));
    }

    public static IntegerBinding sub(int a, ObservableIntegerValue b) {
        return sub(new ConstantInteger(a), b);
    }

    public static IntegerBinding mul(ObservableIntegerValue a, ObservableIntegerValue b) {
        return new IntegerBinding() {
            {
                bind(a, b);
            }

            @Override
            protected int compute() {
                return a.get() * b.get();
            }

            @Override
            public void dispose() {
                unbind(a, b);
            }
        };
    }

    public static IntegerBinding mul(ObservableIntegerValue a, int b) {
        return mul(a, new ConstantInteger(b));
    }

    public static IntegerBinding mul(int a, ObservableIntegerValue b) {
        return mul(new ConstantInteger(a), b);
    }

    public static IntegerBinding div(ObservableIntegerValue a, ObservableIntegerValue b) {
        return new IntegerBinding() {
            {
                bind(a, b);
            }

            @Override
            protected int compute() {
                return a.get() / b.get();
            }

            @Override
            public void dispose() {
                unbind(a, b);
            }
        };
    }

    public static IntegerBinding div(ObservableIntegerValue a, int b) {
        return div(a, new ConstantInteger(b));
    }

    public static IntegerBinding div(int a, ObservableIntegerValue b) {
        return div(new ConstantInteger(a), b);
    }

    public static IntegerBinding sum(ObservableIntegerValue... values) {
        return new IntegerBinding() {
            {
                bind(values);
            }

            @Override
            protected int compute() {
                int sum = 0;
                for (ObservableIntegerValue value : values) {
                    sum += value.get();
                }
                return sum;
            }

            @Override
            public void dispose() {
                unbind(values);
            }
        };
    }

    public static IntegerBinding max(ObservableIntegerValue... values) {
        return new IntegerBinding() {
            {
                bind(values);
            }

            @Override
            protected int compute() {
                int max = values[0].get();
                for (ObservableIntegerValue value : values) {
                    max = Math.max(max, value.get());
                }
                return max;
            }

            @Override
            public void dispose() {
                unbind(values);
            }
        };
    }

    public static IntegerBinding min(ObservableIntegerValue... values) {
        return new IntegerBinding() {
            {
                bind(values);
            }

            @Override
            protected int compute() {
                int min = values[0].get();
                for (ObservableIntegerValue value : values) {
                    min = Math.min(min, value.get());
                }
                return min;
            }

            @Override
            public void dispose() {
                unbind(values);
            }
        };
    }

    public static IntegerBinding min(int max, ObservableIntegerValue... values) {
        return new IntegerBinding() {
            {
                bind(values);
            }

            @Override
            protected int compute() {
                int min = max;
                for (ObservableIntegerValue value : values) {
                    min = Math.min(min, value.get());
                }
                return min;
            }

            @Override
            public void dispose() {
                unbind(values);
            }
        };
    }

    public static IntegerBinding max(int min, ObservableIntegerValue... values) {
        return new IntegerBinding() {
            {
                bind(values);
            }

            @Override
            protected int compute() {
                int max = min;
                for (ObservableIntegerValue value : values) {
                    max = Math.max(max, value.get());
                }
                return max;
            }

            @Override
            public void dispose() {
                unbind(values);
            }
        };
    }

    public static FloatBinding add(ObservableFloatValue a, ObservableFloatValue b) {
        return new FloatBinding() {
            {
                bind(a, b);
            }

            @Override
            protected float compute() {
                return a.get() + b.get();
            }

            @Override
            public void dispose() {
                unbind(a, b);
            }
        };
    }

    public static FloatBinding add(ObservableFloatValue a, float b) {
        return add(a, new ConstantFloat(b));
    }

    public static FloatBinding add(float a, ObservableFloatValue b) {
        return add(new ConstantFloat(a), b);
    }

    public static FloatBinding sub(ObservableFloatValue a, ObservableFloatValue b) {
        return new FloatBinding() {
            {
                bind(a, b);
            }

            @Override
            protected float compute() {
                return a.get() - b.get();
            }

            @Override
            public void dispose() {
                unbind(a, b);
            }
        };
    }

    public static FloatBinding sub(ObservableFloatValue a, float b) {
        return sub(a, new ConstantFloat(b));
    }

    public static FloatBinding sub(float a, ObservableFloatValue b) {
        return sub(new ConstantFloat(a), b);
    }

    public static FloatBinding mul(ObservableFloatValue a, ObservableFloatValue b) {
        return new FloatBinding() {
            {
                bind(a, b);
            }

            @Override
            protected float compute() {
                return a.get() * b.get();
            }

            @Override
            public void dispose() {
                unbind(a, b);
            }
        };
    }

    public static FloatBinding mul(ObservableFloatValue a, float b) {
        return mul(a, new ConstantFloat(b));
    }

    public static FloatBinding mul(float a, ObservableFloatValue b) {
        return mul(new ConstantFloat(a), b);
    }

    public static FloatBinding div(ObservableFloatValue a, ObservableFloatValue b) {
        return new FloatBinding() {
            {
                bind(a, b);
            }

            @Override
            protected float compute() {
                return a.get() / b.get();
            }

            @Override
            public void dispose() {
                unbind(a, b);
            }
        };
    }

    public static FloatBinding div(ObservableFloatValue a, float b) {
        return div(a, new ConstantFloat(b));
    }

    public static FloatBinding div(float a, ObservableFloatValue b) {
        return div(new ConstantFloat(a), b);
    }

    public static FloatBinding sum(ObservableFloatValue... values) {
        return new FloatBinding() {
            {
                bind(values);
            }

            @Override
            protected float compute() {
                float sum = 0;
                for (ObservableFloatValue value : values) {
                    sum += value.get();
                }
                return sum;
            }

            @Override
            public void dispose() {
                unbind(values);
            }
        };
    }

    public static FloatBinding min(ObservableFloatValue... values) {
        return new FloatBinding() {
            {
                bind(values);
            }

            @Override
            protected float compute() {
                float min = values[0].get();
                for (ObservableFloatValue value : values) {
                    min = Math.min(min, value.get());
                }
                return min;
            }

            @Override
            public void dispose() {
                unbind(values);
            }
        };
    }

    public static FloatBinding min(float max, ObservableFloatValue... values) {
        return new FloatBinding() {
            {
                bind(values);
            }

            @Override
            protected float compute() {
                float min = max;
                for (ObservableFloatValue value : values) {
                    min = Math.min(min, value.get());
                }
                return min;
            }

            @Override
            public void dispose() {
                unbind(values);
            }
        };
    }

    public static FloatBinding max(ObservableFloatValue... values) {
        return new FloatBinding() {
            {
                bind(values);
            }

            @Override
            protected float compute() {
                float max = values[0].get();
                for (ObservableFloatValue value : values) {
                    max = Math.max(max, value.get());
                }
                return max;
            }

            @Override
            public void dispose() {
                unbind(values);
            }
        };
    }

    public static FloatBinding max(float min, ObservableFloatValue... values) {
        return new FloatBinding() {
            {
                bind(values);
            }

            @Override
            protected float compute() {
                float max = min;
                for (ObservableFloatValue value : values) {
                    max = Math.max(max, value.get());
                }
                return max;
            }

            @Override
            public void dispose() {
                unbind(values);
            }
        };
    }

    public static <I, O> ObjectBinding<O> map(ObservableValue<I> value, Function<I, O> mapper) {
        return new ObjectBinding<O>() {
            @Override
            protected O compute() {
                return mapper.apply(value.getValue());
            }
        };
    }

    public static <T> IntegerBinding mapToInt(ObservableValue<T> value, Function<T, Integer> mapper) {
        return new IntegerBinding() {
            {
                bind(value);
            }

            @Override
            protected int compute() {
                return mapper.apply(value.getValue());
            }

            @Override
            public void dispose() {
                unbind(value);
            }
        };
    }

    public static <T> FloatBinding mapToFloat(ObservableValue<T> value, Function<T, Float> mapper) {
        return new FloatBinding() {
            {
                bind(value);
            }

            @Override
            protected float compute() {
                return mapper.apply(value.getValue());
            }

            @Override
            public void dispose() {
                unbind(value);
            }
        };
    }

    public static <T> ObjectBinding<T> flatMap(ObservableValue<T> value, Function<T, ObservableValue<T>> mapper) {
        return new ObjectBinding<T>() {

            private ObservableValue<T> observable;

            {
                this.observable = mapper.apply(value.getValue());
                bind(value, this.observable);
            }

            @Override
            protected T compute() {
                unbind(this.observable);
                this.observable = mapper.apply(value.getValue());
                bind(this.observable);

                return this.observable.getValue();
            }

            @Override
            public void dispose() {
                unbind(value, this.observable);
            }
        };
    }
}

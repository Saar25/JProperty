package org.jproperty

import org.jproperty.binding.Bindings
import org.jproperty.binding.FloatBinding
import org.jproperty.binding.IntegerBinding
import org.jproperty.binding.ObjectBinding
import org.jproperty.value.ObservableFloatValue
import org.jproperty.value.ObservableIntegerValue
import org.jproperty.value.ObservableNumberValue
import org.jproperty.value.ObservableObjectValue

operator fun ObservableIntegerValue.plus(other: ObservableIntegerValue): IntegerBinding = Bindings.add(this, other)
operator fun ObservableIntegerValue.plus(other: Int): IntegerBinding = Bindings.add(this, other)

operator fun ObservableIntegerValue.minus(other: ObservableIntegerValue): IntegerBinding = Bindings.sub(this, other)
operator fun ObservableIntegerValue.minus(other: Int): IntegerBinding = Bindings.sub(this, other)

operator fun ObservableIntegerValue.times(other: ObservableIntegerValue): IntegerBinding = Bindings.mul(this, other)
operator fun ObservableIntegerValue.times(other: Int): IntegerBinding = Bindings.mul(this, other)

operator fun ObservableIntegerValue.div(other: ObservableIntegerValue): IntegerBinding = Bindings.div(this, other)
operator fun ObservableIntegerValue.div(other: Int): IntegerBinding = Bindings.div(this, other)

infix fun ObservableIntegerValue.max(other: ObservableIntegerValue): IntegerBinding = Bindings.max(this, other)
infix fun ObservableIntegerValue.max(other: Int): IntegerBinding = Bindings.max(other, this)

infix fun ObservableIntegerValue.min(other: ObservableIntegerValue): IntegerBinding = Bindings.min(this, other)
infix fun ObservableIntegerValue.min(other: Int): IntegerBinding = Bindings.min(other, this)

operator fun ObservableFloatValue.plus(other: ObservableFloatValue): FloatBinding = Bindings.add(this, other)
operator fun ObservableFloatValue.plus(other: Float): FloatBinding = Bindings.add(this, other)

operator fun ObservableFloatValue.minus(other: ObservableFloatValue): FloatBinding = Bindings.sub(this, other)
operator fun ObservableFloatValue.minus(other: Float): FloatBinding = Bindings.sub(this, other)

operator fun ObservableFloatValue.times(other: ObservableFloatValue): FloatBinding = Bindings.mul(this, other)
operator fun ObservableFloatValue.times(other: Float): FloatBinding = Bindings.mul(this, other)

operator fun ObservableFloatValue.div(other: ObservableFloatValue): FloatBinding = Bindings.div(this, other)
operator fun ObservableFloatValue.div(other: Float): FloatBinding = Bindings.div(this, other)

infix fun ObservableFloatValue.max(other: ObservableFloatValue): FloatBinding = Bindings.max(this, other)
infix fun ObservableFloatValue.max(other: Float): FloatBinding = Bindings.max(other, this)

infix fun ObservableFloatValue.min(other: ObservableFloatValue): FloatBinding = Bindings.min(this, other)
infix fun ObservableFloatValue.min(other: Float): FloatBinding = Bindings.min(other, this)

fun <T> ObservableValue<T>.mapToInteger(mapper: (T) -> Int): IntegerBinding = Bindings.mapToInt(this, mapper)
fun <T> ObservableValue<T>.mapToFloat(mapper: (T) -> Float): FloatBinding = Bindings.mapToFloat(this, mapper)
fun <I, O> ObservableValue<I>.map(mapper: (I) -> O): Binding<O> = Bindings.map(this, mapper)

fun <T> ObservableValue<T>.flatMapToInteger(mapper: (T) -> ObservableNumberValue): IntegerBinding =
    Bindings.flatMapToInteger(this, mapper)

fun <T> ObservableValue<T>.flatMapToFloat(mapper: (T) -> ObservableNumberValue): FloatBinding =
    Bindings.flatMapToFloat(this, mapper)

fun <I, O> ObservableValue<I>.flatMap(mapper: (I) -> ObservableObjectValue<O>): ObjectBinding<O> =
    Bindings.flatMap(this, mapper)

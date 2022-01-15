package org.jproperty

import org.jproperty.expression.*
import org.jproperty.value.ObservableFloatValue
import org.jproperty.value.ObservableIntegerValue
import org.jproperty.value.ObservableNumberValue

operator fun ObservableIntegerValue.plus(other: ObservableNumberValue): IntExpression = IntExpressions.add(this, other)
operator fun ObservableIntegerValue.plus(other: Int): IntExpression = IntExpressions.add(this, other)

operator fun ObservableIntegerValue.minus(other: ObservableNumberValue): IntExpression = IntExpressions.sub(this, other)
operator fun ObservableIntegerValue.minus(other: Int): IntExpression = IntExpressions.sub(this, other)

operator fun ObservableIntegerValue.times(other: ObservableNumberValue): IntExpression = IntExpressions.mul(this, other)
operator fun ObservableIntegerValue.times(other: Int): IntExpression = IntExpressions.mul(this, other)

operator fun ObservableIntegerValue.div(other: ObservableNumberValue): IntExpression = IntExpressions.div(this, other)
operator fun ObservableIntegerValue.div(other: Int): IntExpression = IntExpressions.div(this, other)

infix fun ObservableIntegerValue.max(other: ObservableNumberValue): IntExpression = IntExpressions.max(this, other)
infix fun ObservableIntegerValue.max(other: Int): IntExpression = IntExpressions.max(other, this)

infix fun ObservableIntegerValue.min(other: ObservableNumberValue): IntExpression = IntExpressions.min(this, other)
infix fun ObservableIntegerValue.min(other: Int): IntExpression = IntExpressions.min(other, this)

operator fun ObservableFloatValue.plus(other: ObservableNumberValue): FloatExpression = FloatExpressions.add(this, other)
operator fun ObservableFloatValue.plus(other: Float): FloatExpression = FloatExpressions.add(this, other)

operator fun ObservableFloatValue.minus(other: ObservableNumberValue): FloatExpression = FloatExpressions.sub(this, other)
operator fun ObservableFloatValue.minus(other: Float): FloatExpression = FloatExpressions.sub(this, other)

operator fun ObservableFloatValue.times(other: ObservableNumberValue): FloatExpression = FloatExpressions.mul(this, other)
operator fun ObservableFloatValue.times(other: Float): FloatExpression = FloatExpressions.mul(this, other)

operator fun ObservableFloatValue.div(other: ObservableNumberValue): FloatExpression = FloatExpressions.div(this, other)
operator fun ObservableFloatValue.div(other: Float): FloatExpression = FloatExpressions.div(this, other)

infix fun ObservableFloatValue.max(other: ObservableNumberValue): FloatExpression = FloatExpressions.max(this, other)
infix fun ObservableFloatValue.max(other: Float): FloatExpression = FloatExpressions.max(other, this)

infix fun ObservableFloatValue.min(other: ObservableNumberValue): FloatExpression = FloatExpressions.min(this, other)
infix fun ObservableFloatValue.min(other: Float): FloatExpression = FloatExpressions.min(other, this)

fun <T> ObservableValue<T>.mapToInt(mapper: (T) -> Int): IntExpression = Expressions.mapToInt(this, mapper)
fun <T> ObservableValue<T>.mapToFloat(mapper: (T) -> Float): FloatExpression = Expressions.mapToFloat(this, mapper)
fun <I, O> ObservableValue<I>.map(mapper: (I) -> O): Expression<O> = Expressions.map(this, mapper)

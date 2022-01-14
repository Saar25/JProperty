package org.jproperty

import org.jproperty.expression.*
import org.jproperty.type.ReadOnlyFloatProperty
import org.jproperty.type.ReadOnlyIntProperty
import org.jproperty.type.ReadOnlyNumberProperty

operator fun ReadOnlyIntProperty.plus(other: ReadOnlyNumberProperty): IntExpression = IntExpressions.add(this, other)
operator fun ReadOnlyIntProperty.plus(other: Int): IntExpression = IntExpressions.add(this, other)

operator fun ReadOnlyIntProperty.minus(other: ReadOnlyNumberProperty): IntExpression = IntExpressions.sub(this, other)
operator fun ReadOnlyIntProperty.minus(other: Int): IntExpression = IntExpressions.sub(this, other)

operator fun ReadOnlyIntProperty.times(other: ReadOnlyNumberProperty): IntExpression = IntExpressions.mul(this, other)
operator fun ReadOnlyIntProperty.times(other: Int): IntExpression = IntExpressions.mul(this, other)

operator fun ReadOnlyIntProperty.div(other: ReadOnlyNumberProperty): IntExpression = IntExpressions.div(this, other)
operator fun ReadOnlyIntProperty.div(other: Int): IntExpression = IntExpressions.div(this, other)

infix fun ReadOnlyIntProperty.max(other: ReadOnlyNumberProperty): IntExpression = IntExpressions.max(this, other)
infix fun ReadOnlyIntProperty.max(other: Int): IntExpression = IntExpressions.max(other, this)

infix fun ReadOnlyIntProperty.min(other: ReadOnlyNumberProperty): IntExpression = IntExpressions.min(this, other)
infix fun ReadOnlyIntProperty.min(other: Int): IntExpression = IntExpressions.min(other, this)

operator fun ReadOnlyFloatProperty.plus(other: ReadOnlyNumberProperty): FloatExpression = FloatExpressions.add(this, other)
operator fun ReadOnlyFloatProperty.plus(other: Float): FloatExpression = FloatExpressions.add(this, other)

operator fun ReadOnlyFloatProperty.minus(other: ReadOnlyNumberProperty): FloatExpression = FloatExpressions.sub(this, other)
operator fun ReadOnlyFloatProperty.minus(other: Float): FloatExpression = FloatExpressions.sub(this, other)

operator fun ReadOnlyFloatProperty.times(other: ReadOnlyNumberProperty): FloatExpression = FloatExpressions.mul(this, other)
operator fun ReadOnlyFloatProperty.times(other: Float): FloatExpression = FloatExpressions.mul(this, other)

operator fun ReadOnlyFloatProperty.div(other: ReadOnlyNumberProperty): FloatExpression = FloatExpressions.div(this, other)
operator fun ReadOnlyFloatProperty.div(other: Float): FloatExpression = FloatExpressions.div(this, other)

infix fun ReadOnlyFloatProperty.max(other: ReadOnlyNumberProperty): FloatExpression = FloatExpressions.max(this, other)
infix fun ReadOnlyFloatProperty.max(other: Float): FloatExpression = FloatExpressions.max(other, this)

infix fun ReadOnlyFloatProperty.min(other: ReadOnlyNumberProperty): FloatExpression = FloatExpressions.min(this, other)
infix fun ReadOnlyFloatProperty.min(other: Float): FloatExpression = FloatExpressions.min(other, this)

fun <T> ReadOnlyProperty<T>.mapToInt(mapper: (T) -> Int): IntExpression = Expressions.mapToInt(this, mapper)
fun <T> ReadOnlyProperty<T>.mapToFloat(mapper: (T) -> Float): FloatExpression = Expressions.mapToFloat(this, mapper)
fun <I, O> ReadOnlyProperty<I>.map(mapper: (I) -> O): Expression<O> = Expressions.map(this, mapper)

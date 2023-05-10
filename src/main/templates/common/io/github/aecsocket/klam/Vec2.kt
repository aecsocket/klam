@file:Suppress("NOTHING_TO_INLINE")

package io.github.aecsocket.klam

data class {{ T }}Vec2(
    @JvmField val x: {{ Type }},
    @JvmField val y: {{ Type }},
) {
    companion object {
        val {{ Zero }} get() = {{ T }}Vec2({{ zero }}, {{ zero }})
        val {{ One }} get() = {{ T }}Vec2({{ one }}, {{ one }})

        val X get() = {{ T }}Vec2({{ one }}, {{ zero }})
        val Y get() = {{ T }}Vec2({{ zero }}, {{ one }})
    }

    constructor(s: {{ Type }}) : this(s, s)

    operator fun get(index: Int) = when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException(index)
    }

    fun x(x: {{ Type }}) = {{ T }}Vec2(x, y)
    fun y(y: {{ Type }}) = {{ T }}Vec2(x, y)

    fun toArray() = {{ arrayOf }}(x, y)

    fun asString(fmt: String) = "($fmt, $fmt)".format(x, y)
    override fun toString() = asString("{{ toStringFormat }}")

    inline fun map(block: ({{ Type }}) -> {{ Type }}) = {{ T }}Vec2(block(x), block(y))

{% if isNumber %}
    inline operator fun unaryMinus() = {{ T }}Vec2(-x, -y)
    inline operator fun inc() = {{ T }}Vec2(x + {{ one }}, y + {{ one }})
    inline operator fun dec() = {{ T }}Vec2(x - {{ one }}, y - {{ one }})

    @JvmName("add")
    inline operator fun plus (s: {{ Type }}) = {{ T }}Vec2(x + s, y + s)
    @JvmName("sub")
    inline operator fun minus(s: {{ Type }}) = {{ T }}Vec2(x - s, y - s)
    @JvmName("mul")
    inline operator fun times(s: {{ Type }}) = {{ T }}Vec2(x * s, y * s)
    @JvmName("div")
    inline operator fun div  (s: {{ Type }}) = {{ T }}Vec2(x / s, y / s)

    @JvmName("add")
    inline operator fun plus (v: {{ T }}Vec2) = {{ T }}Vec2(x + v.x, y + v.y)
    @JvmName("sub")
    inline operator fun minus(v: {{ T }}Vec2) = {{ T }}Vec2(x - v.x, y - v.y)
    @JvmName("mul")
    inline operator fun times(v: {{ T }}Vec2) = {{ T }}Vec2(x * v.x, y * v.y)
    @JvmName("div")
    inline operator fun div  (v: {{ T }}Vec2) = {{ T }}Vec2(x / v.x, y / v.y)
{% else %}
    inline operator fun not() = {{ T }}Vec2(!x, !y)
{% endif %}

    fun compareTo(v: {{ T }}Vec2) = IVec2(x.compareTo(v.x), y.compareTo(v.y))

    inline infix fun eq(v: {{ T }}Vec2) = BVec2(x.compareTo(v.x) == 0, y.compareTo(v.y) == 0)
    inline infix fun ne(v: {{ T }}Vec2) = BVec2(x.compareTo(v.x) != 0, y.compareTo(v.y) != 0)

{% if isNumber %}
    inline infix fun lt(v: {{ T }}Vec2) = BVec2(x  < v.x, y  < v.y)
    inline infix fun le(v: {{ T }}Vec2) = BVec2(x <= v.x, y <= v.y)
    inline infix fun gt(v: {{ T }}Vec2) = BVec2(x  > v.x, y  > v.y)
    inline infix fun ge(v: {{ T }}Vec2) = BVec2(x >= v.x, y >= v.y)
{% endif %}
}

{% if isNumber %}
@JvmName("add")
inline operator fun {{ Type }}.plus (v: {{ T }}Vec2) = {{ T }}Vec2(this + v.x, this + v.y)
@JvmName("sub")
inline operator fun {{ Type }}.minus(v: {{ T }}Vec2) = {{ T }}Vec2(this - v.x, this - v.y)
@JvmName("mul")
inline operator fun {{ Type }}.times(v: {{ T }}Vec2) = {{ T }}Vec2(this * v.x, this * v.y)
@JvmName("div")
inline operator fun {{ Type }}.div  (v: {{ T }}Vec2) = {{ T }}Vec2(this / v.x, this / v.y)

inline fun min(a: {{ T }}Vec2, b: {{ T }}Vec2) = {{ T }}Vec2(kotlin.math.min(a.x, b.x), kotlin.math.min(a.y, b.y))

inline fun max(a: {{ T }}Vec2, b: {{ T }}Vec2) = {{ T }}Vec2(kotlin.math.max(a.x, b.x), kotlin.math.max(a.y, b.y))

inline fun minComponent(v: {{ T }}Vec2) = kotlin.math.min(v.x, v.y)

inline fun maxComponent(v: {{ T }}Vec2) = kotlin.math.max(v.x, v.y)

inline fun clamp(v: {{ T }}Vec2, min: {{ T }}Vec2, max: {{ T }}Vec2) = {{ T }}Vec2(clamp(v.x, min.x, max.x), clamp(v.y, min.y, max.y))

inline fun clamp(v: {{ T }}Vec2, min: {{ Type }}, max: {{ Type }}) = {{ T }}Vec2(clamp(v.x, min, max), clamp(v.y, min, max))

inline fun abs(v: {{ T }}Vec2) = {{ T }}Vec2(kotlin.math.abs(v.x), kotlin.math.abs(v.y))

{% if isDecimal %}
inline fun lengthSq(v: {{ T }}Vec2) = sqr(v.x) + sqr(v.y)

inline fun length(v: {{ T }}Vec2) = kotlin.math.sqrt(lengthSq(v))

inline fun normalize(v: {{ T }}Vec2): {{ T }}Vec2 {
    val l = {{ one }} / length(v)
    return {{ T }}Vec2(v.x * l, v.y * l)
}

inline fun distanceSq(a: {{ T }}Vec2, b: {{ T }}Vec2) = lengthSq(b - a)

inline fun distance(a: {{ T }}Vec2, b: {{ T }}Vec2) = length(b - a)

inline fun mix(a: {{ T }}Vec2, b: {{ T }}Vec2, f: {{ Type }}) = {{ T }}Vec2(mix(a.x, b.x, f), mix(a.y, b.y, f))

inline fun dot(a: {{ T }}Vec2, b: {{ T }}Vec2) = a.x * b.x + a.y * b.y
{% endif %}
{% else %}
inline fun all(v: {{ T }}Vec2) = v.x && v.y

inline fun any(v: {{ T }}Vec2) = v.x || v.y

inline fun none(v: {{ T }}Vec2) = !v.x && !v.y
{% endif %}

fun JRandom.next{{ T }}Vec2() = {{ T }}Vec2({{ nextRandom }}(), {{ nextRandom }}())

fun KRandom.next{{ T }}Vec2() = {{ T }}Vec2({{ nextRandom }}(), {{ nextRandom }}())

//region Alternate accessors
{{ vecAlternateAccessors2 }}
//endregion

//region Swizzles
{{ vecSwizzles2 }}
//endregion

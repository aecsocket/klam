@file:Suppress("NOTHING_TO_INLINE")

package io.github.aecsocket.klam

data class {{ T }}Vec4(
    @JvmField val x: {{ Type }},
    @JvmField val y: {{ Type }},
    @JvmField val z: {{ Type }},
    @JvmField val w: {{ Type }},
) {
    companion object {
        val {{ Zero }} get() = {{ T }}Vec4({{ zero }}, {{ zero }}, {{ zero }}, {{ zero }})
        val {{ One }} get() = {{ T }}Vec4({{ one }}, {{ one }}, {{ one }}, {{ one }})

        val X get() = {{ T }}Vec4({{ one }}, {{ zero }}, {{ zero }}, {{ zero }})
        val Y get() = {{ T }}Vec4({{ zero }}, {{ one }}, {{ zero }}, {{ zero }})
        val Z get() = {{ T }}Vec4({{ zero }}, {{ zero }}, {{ one }}, {{ zero }})
        val W get() = {{ T }}Vec4({{ zero }}, {{ zero }}, {{ zero }}, {{ one }})
    }

    constructor(v: {{ T }}Vec2, z: {{ Type }}, w: {{ Type }}) : this(v.x, v.y, z, w)
    constructor(v: {{ T }}Vec3, w: {{ Type }}) : this(v.x, v.y, v.z, w)
    constructor(s: {{ Type }}) : this(s, s, s, s)

    operator fun get(index: Int) = when (index) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw IndexOutOfBoundsException(index)
    }

    fun x(x: {{ Type }}) = {{ T }}Vec4(x, y, z, w)
    fun y(y: {{ Type }}) = {{ T }}Vec4(x, y, z, w)
    fun z(z: {{ Type }}) = {{ T }}Vec4(x, y, z, w)
    fun w(w: {{ Type }}) = {{ T }}Vec4(x, y, z, w)

    fun toArray() = {{ arrayOf }}(x, y, z, w)

    fun asString(fmt: String) = "($fmt, $fmt, $fmt, $fmt)".format(x, y, z, w)
    override fun toString() = asString("{{ toStringFormat }}")

    inline fun map(block: ({{ Type }}) -> {{ Type }}) = {{ T }}Vec4(block(x), block(y), block(z), block(w))

{% if isNumber %}
    inline operator fun unaryMinus() = {{ T }}Vec4(-x, -y, -z, -w)
    inline operator fun inc() = {{ T }}Vec4(x + {{ one }}, y + {{ one }}, z + {{ one }}, w + {{ one }})
    inline operator fun dec() = {{ T }}Vec4(x - {{ one }}, y - {{ one }}, z - {{ one }}, w - {{ one }})

    @JvmName("add")
    inline operator fun plus (s: {{ Type }}) = {{ T }}Vec4(x + s, y + s, z + s, w + s)
    @JvmName("sub")
    inline operator fun minus(s: {{ Type }}) = {{ T }}Vec4(x - s, y - s, z - s, w - s)
    @JvmName("mul")
    inline operator fun times(s: {{ Type }}) = {{ T }}Vec4(x * s, y * s, z * s, w * s)
    @JvmName("div")
    inline operator fun div  (s: {{ Type }}) = {{ T }}Vec4(x / s, y / s, z / s, w / s)

    @JvmName("add")
    inline operator fun plus (v: {{ T }}Vec4) = {{ T }}Vec4(x + v.x, y + v.y, z + v.z, w + v.w)
    @JvmName("sub")
    inline operator fun minus(v: {{ T }}Vec4) = {{ T }}Vec4(x - v.x, y - v.y, z - v.z, w - v.w)
    @JvmName("mul")
    inline operator fun times(v: {{ T }}Vec4) = {{ T }}Vec4(x * v.x, y * v.y, z * v.z, w * v.w)
    @JvmName("div")
    inline operator fun div  (v: {{ T }}Vec4) = {{ T }}Vec4(x / v.x, y / v.y, z / v.z, w / v.w)
{% else %}
    inline operator fun not() = {{ T }}Vec4(!x, !y, !z, !w)
{% endif %}

    fun compareTo(v: {{ T }}Vec4) = IVec4(x.compareTo(v.x), y.compareTo(v.y), z.compareTo(v.z), w.compareTo(v.w))

    inline infix fun eq(v: {{ T }}Vec4) = BVec4(x.compareTo(v.x) == 0, y.compareTo(v.y) == 0, z.compareTo(v.z) == 0, w.compareTo(v.w) == 0)
    inline infix fun ne(v: {{ T }}Vec4) = BVec4(x.compareTo(v.x) != 0, y.compareTo(v.y) != 0, z.compareTo(v.z) != 0, w.compareTo(v.w) != 0)

{% if isNumber %}
    inline infix fun lt(v: {{ T }}Vec4) = BVec4(x  < v.x, y  < v.y, z  < v.z, w  < v.w)
    inline infix fun le(v: {{ T }}Vec4) = BVec4(x <= v.x, y <= v.y, z <= v.z, w <= v.w)
    inline infix fun gt(v: {{ T }}Vec4) = BVec4(x  > v.x, y  > v.y, z  > v.z, w  > v.w)
    inline infix fun ge(v: {{ T }}Vec4) = BVec4(x >= v.x, y >= v.y, z >= v.z, w >= v.w)
{% endif %}
}

{% if isNumber %}
@JvmName("add")
inline operator fun {{ Type }}.plus (v: {{ T }}Vec4) = {{ T }}Vec4(this + v.x, this + v.y, this + v.z, this + v.w)
@JvmName("sub")
inline operator fun {{ Type }}.minus(v: {{ T }}Vec4) = {{ T }}Vec4(this - v.x, this - v.y, this - v.z, this - v.w)
@JvmName("mul")
inline operator fun {{ Type }}.times(v: {{ T }}Vec4) = {{ T }}Vec4(this * v.x, this * v.y, this * v.z, this * v.w)
@JvmName("div")
inline operator fun {{ Type }}.div  (v: {{ T }}Vec4) = {{ T }}Vec4(this / v.x, this / v.y, this / v.z, this / v.w)

inline fun min(a: {{ T }}Vec4, b: {{ T }}Vec4) = {{ T }}Vec4(kotlin.math.min(a.x, b.x), kotlin.math.min(a.y, b.y), kotlin.math.min(a.z, b.z), kotlin.math.min(a.w, b.w))

inline fun max(a: {{ T }}Vec4, b: {{ T }}Vec4) = {{ T }}Vec4(kotlin.math.max(a.x, b.x), kotlin.math.max(a.y, b.y), kotlin.math.max(a.z, b.z), kotlin.math.max(a.w, b.w))

inline fun minComponent(v: {{ T }}Vec4) = kotlin.math.min(v.x, kotlin.math.min(v.y, kotlin.math.min(v.z, v.w)))

inline fun maxComponent(v: {{ T }}Vec4) = kotlin.math.max(v.x, kotlin.math.max(v.y, kotlin.math.max(v.z, v.w)))

inline fun clamp(v: {{ T }}Vec4, min: {{ T }}Vec4, max: {{ T }}Vec4) = {{ T }}Vec4(clamp(v.x, min.x, max.x), clamp(v.y, min.y, max.y), clamp(v.z, min.z, max.z), clamp(v.w, min.w, max.w))

inline fun clamp(v: {{ T }}Vec4, min: {{ Type }}, max: {{ Type }}) = {{ T }}Vec4(clamp(v.x, min, max), clamp(v.y, min, max), clamp(v.z, min, max), clamp(v.w, min, max))

inline fun abs(v: {{ T }}Vec4) = {{ T }}Vec4(kotlin.math.abs(v.x), kotlin.math.abs(v.y), kotlin.math.abs(v.z), kotlin.math.abs(v.w))

{% if isDecimal %}
inline fun lengthSq(v: {{ T }}Vec4) = sqr(v.x) + sqr(v.y) + sqr(v.z) + sqr(v.w)

inline fun length(v: {{ T }}Vec4) = kotlin.math.sqrt(lengthSq(v))

inline fun normalize(v: {{ T }}Vec4): {{ T }}Vec4 {
    val l = {{ one }} / length(v)
    return {{ T }}Vec4(v.x * l, v.y * l, v.z * l, v.w * l)
}

inline fun distanceSq(a: {{ T }}Vec4, b: {{ T }}Vec4) = lengthSq(b - a)

inline fun distance(a: {{ T }}Vec4, b: {{ T }}Vec4) = length(b - a)

inline fun mix(a: {{ T }}Vec4, b: {{ T }}Vec4, f: {{ Type }}) = {{ T }}Vec4(mix(a.x, b.x, f), mix(a.y, b.y, f), mix(a.z, b.z, f), mix(a.w, b.w, f))

inline fun dot(a: {{ T }}Vec4, b: {{ T }}Vec4) = a.x * b.x + a.y * b.y + a.z * b.z + a.w * b.w
{% endif %}
{% else %}
inline fun all(v: {{ T }}Vec4) = v.x && v.y && v.z && v.w

inline fun any(v: {{ T }}Vec4) = v.x || v.y || v.z || v.w

inline fun none(v: {{ T }}Vec4) = !v.x && !v.y && !v.z && !v.w
{% endif %}

fun JRandom.next{{ T }}Vec4() = {{ T }}Vec4({{ nextRandom }}(), {{ nextRandom }}(), {{ nextRandom }}(), {{ nextRandom }}())

fun KRandom.next{{ T }}Vec4() = {{ T }}Vec4({{ nextRandom }}(), {{ nextRandom }}(), {{ nextRandom }}(), {{ nextRandom }}())

//region Alternate accessors
{{ vecAlternateAccessors4 }}
//endregion

//region Swizzles
{{ vecSwizzles4 }}
//endregion

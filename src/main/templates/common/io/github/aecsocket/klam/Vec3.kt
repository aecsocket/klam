@file:Suppress("NOTHING_TO_INLINE")

package io.github.aecsocket.klam

data class {{ T }}Vec3(
    @JvmField val x: {{ Type }},
    @JvmField val y: {{ Type }},
    @JvmField val z: {{ Type }},
) {
    companion object {
        val {{ Zero }} get() = {{ T }}Vec3({{ zero }}, {{ zero }}, {{ zero }})
        val {{ One }} get() = {{ T }}Vec3({{ one }}, {{ one }}, {{ one }})

        val X get() = {{ T }}Vec3({{ one }}, {{ zero }}, {{ zero }})
        val Y get() = {{ T }}Vec3({{ zero }}, {{ one }}, {{ zero }})
        val Z get() = {{ T }}Vec3({{ zero }}, {{ zero }}, {{ one }})
    }

    constructor(v: {{ T }}Vec2, z: {{ Type }}) : this(v.x, v.y, z)
    constructor(s: {{ Type }}) : this(s, s, s)

    operator fun get(index: Int) = when (index) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw IndexOutOfBoundsException(index)
    }

    fun x(x: {{ Type }}) = {{ T }}Vec3(x, y, z)
    fun y(y: {{ Type }}) = {{ T }}Vec3(x, y, z)
    fun z(z: {{ Type }}) = {{ T }}Vec3(x, y, z)

    fun toArray() = {{ arrayOf }}(x, y, z)

    fun asString(fmt: String) = "($fmt, $fmt, $fmt)".format(x, y, z)
    override fun toString() = asString("{{ toStringFormat }}")

    inline fun map(block: ({{ Type }}) -> {{ Type }}) = {{ T }}Vec3(block(x), block(y), block(z))

{% for cast in numberCasts %}
    inline fun map{{ cast.Type }}(block: ({{ Type }}) -> {{ cast.Type }}) = {{ cast.T }}Vec3(block(x), block(y), block(z))
    fun {{ cast.fn }} = {{ cast.T }}Vec3(x.{{ cast.fn }}, y.{{ cast.fn }}, z.{{ cast.fn }})

{% endfor %}
{% if isNumber %}
    inline operator fun unaryMinus() = {{ T }}Vec3(-x, -y, -z)
    inline operator fun inc() = {{ T }}Vec3(x + {{ one }}, y + {{ one }}, z + {{ one }})
    inline operator fun dec() = {{ T }}Vec3(x - {{ one }}, y - {{ one }}, z - {{ one }})

    @JvmName("add")
    inline operator fun plus (s: {{ Type }}) = {{ T }}Vec3(x + s, y + s, z + s)
    @JvmName("sub")
    inline operator fun minus(s: {{ Type }}) = {{ T }}Vec3(x - s, y - s, z - s)
    @JvmName("mul")
    inline operator fun times(s: {{ Type }}) = {{ T }}Vec3(x * s, y * s, z * s)
    @JvmName("div")
    inline operator fun div  (s: {{ Type }}) = {{ T }}Vec3(x / s, y / s, z / s)

    @JvmName("add")
    inline operator fun plus (v: {{ T }}Vec3) = {{ T }}Vec3(x + v.x, y + v.y, z + v.z)
    @JvmName("sub")
    inline operator fun minus(v: {{ T }}Vec3) = {{ T }}Vec3(x - v.x, y - v.y, z - v.z)
    @JvmName("mul")
    inline operator fun times(v: {{ T }}Vec3) = {{ T }}Vec3(x * v.x, y * v.y, z * v.z)
    @JvmName("div")
    inline operator fun div  (v: {{ T }}Vec3) = {{ T }}Vec3(x / v.x, y / v.y, z / v.z)
{% else %}
    inline operator fun not() = {{ T }}Vec3(!x, !y, !z)
{% endif %}

    fun compareTo(v: {{ T }}Vec3) = IVec3(x.compareTo(v.x), y.compareTo(v.y), z.compareTo(v.z))

    inline infix fun eq(v: {{ T }}Vec3) = BVec3(x.compareTo(v.x) == 0, y.compareTo(v.y) == 0, z.compareTo(v.z) == 0)
    inline infix fun ne(v: {{ T }}Vec3) = BVec3(x.compareTo(v.x) != 0, y.compareTo(v.y) != 0, z.compareTo(v.z) != 0)

{% if isNumber %}
    inline infix fun lt(v: {{ T }}Vec3) = BVec3(x  < v.x, y  < v.y, z  < v.z)
    inline infix fun le(v: {{ T }}Vec3) = BVec3(x <= v.x, y <= v.y, z <= v.z)
    inline infix fun gt(v: {{ T }}Vec3) = BVec3(x  > v.x, y  > v.y, z  > v.z)
    inline infix fun ge(v: {{ T }}Vec3) = BVec3(x >= v.x, y >= v.y, z >= v.z)
{% endif %}
}

{% if isNumber %}
@JvmName("add")
inline operator fun {{ Type }}.plus (v: {{ T }}Vec3) = {{ T }}Vec3(this + v.x, this + v.y, this + v.z)
@JvmName("sub")
inline operator fun {{ Type }}.minus(v: {{ T }}Vec3) = {{ T }}Vec3(this - v.x, this - v.y, this - v.z)
@JvmName("mul")
inline operator fun {{ Type }}.times(v: {{ T }}Vec3) = {{ T }}Vec3(this * v.x, this * v.y, this * v.z)
@JvmName("div")
inline operator fun {{ Type }}.div  (v: {{ T }}Vec3) = {{ T }}Vec3(this / v.x, this / v.y, this / v.z)

inline fun min(a: {{ T }}Vec3, b: {{ T }}Vec3) = {{ T }}Vec3(kotlin.math.min(a.x, b.x), kotlin.math.min(a.y, b.y), kotlin.math.min(a.z, b.z))

inline fun max(a: {{ T }}Vec3, b: {{ T }}Vec3) = {{ T }}Vec3(kotlin.math.max(a.x, b.x), kotlin.math.max(a.y, b.y), kotlin.math.max(a.z, b.z))

inline fun minComponent(v: {{ T }}Vec3) = kotlin.math.min(v.x, kotlin.math.min(v.y, v.z))

inline fun maxComponent(v: {{ T }}Vec3) = kotlin.math.max(v.x, kotlin.math.max(v.y, v.z))

inline fun clamp(v: {{ T }}Vec3, min: {{ T }}Vec3, max: {{ T }}Vec3) = {{ T }}Vec3(clamp(v.x, min.x, max.x), clamp(v.y, min.y, max.y), clamp(v.z, min.z, max.z))

inline fun clamp(v: {{ T }}Vec3, min: {{ Type }}, max: {{ Type }}) = {{ T }}Vec3(clamp(v.x, min, max), clamp(v.y, min, max), clamp(v.z, min, max))

inline fun abs(v: {{ T }}Vec3) = {{ T }}Vec3(kotlin.math.abs(v.x), kotlin.math.abs(v.y), kotlin.math.abs(v.z))

{% if isDecimal %}
inline fun lengthSq(v: {{ T }}Vec3) = sqr(v.x) + sqr(v.y) + sqr(v.z)

inline fun length(v: {{ T }}Vec3) = kotlin.math.sqrt(lengthSq(v))

inline fun normalize(v: {{ T }}Vec3): {{ T }}Vec3 {
    val l = {{ one }} / length(v)
    return {{ T }}Vec3(v.x * l, v.y * l, v.z * l)
}

inline fun distanceSq(a: {{ T }}Vec3, b: {{ T }}Vec3) = lengthSq(b - a)

inline fun distance(a: {{ T }}Vec3, b: {{ T }}Vec3) = length(b - a)

inline fun midpoint(a: {{ T }}Vec3, b: {{ T }}Vec3) = (a + b) * {{ half }}

inline fun mix(a: {{ T }}Vec3, b: {{ T }}Vec3, f: {{ Type }}) = {{ T }}Vec3(mix(a.x, b.x, f), mix(a.y, b.y, f), mix(a.z, b.z, f))

inline fun dot(a: {{ T }}Vec3, b: {{ T }}Vec3) = a.x * b.x + a.y * b.y + a.z * b.z

inline fun cross(a: {{ T }}Vec3, b: {{ T }}Vec3) = {{ T }}Vec3(
    a.y * b.z - a.z * b.y,
    a.z * b.x - a.x * b.z,
    a.x * b.y - a.y * b.x,
)
{% endif %}
{% else %}
inline fun all(v: {{ T }}Vec3) = v.x && v.y && v.z

inline fun any(v: {{ T }}Vec3) = v.x || v.y || v.z

inline fun none(v: {{ T }}Vec3) = !v.x && !v.y && !v.z
{% endif %}

fun JRandom.next{{ T }}Vec3() = {{ T }}Vec3({{ nextRandom }}(), {{ nextRandom }}(), {{ nextRandom }}())

fun KRandom.next{{ T }}Vec3() = {{ T }}Vec3({{ nextRandom }}(), {{ nextRandom }}(), {{ nextRandom }}())

//region Alternate accessors
{{ vecAlternateAccessors3 }}
//endregion

//region Swizzles
{{ vecSwizzles3 }}
//endregion

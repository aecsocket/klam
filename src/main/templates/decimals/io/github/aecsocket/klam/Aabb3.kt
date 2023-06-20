@file:Suppress("NOTHING_TO_INLINE")

package io.github.aecsocket.klam

data class {{ T }}Aabb3(
    @JvmField val min: {{ T }}Vec3,
    @JvmField val max: {{ T }}Vec3,
) {
    fun asString(fmt: String) = "[${min.asString(fmt)} .. ${max.asString(fmt)}]"
    override fun toString() = asString("{{ toStringFormat }}")

    inline fun mapVector(block: ({{ T }}Vec3) -> {{ T }}Vec3) = {{ T }}Aabb3(block(min), block(max))
    inline fun mapScalar(block: ({{ Type }}) -> {{ Type }}) = {{ T }}Aabb3(min.map(block), max.map(block))

{% for cast in decimalCasts %}
    inline fun mapVector(block: ({{ T }}Vec3) -> {{ cast.T }}Vec3) = {{ cast.T }}Aabb3(block(min), block(max))
    inline fun mapScalar(block: ({{ Type }}) -> {{ cast.Type }}) = {{ cast.T }}Aabb3(min.map(block), max.map(block))
    fun {{ cast.fn }} = {{ cast.T }}Aabb3(min.{{ cast.fn }}, max.{{ cast.fn }})

{% endfor %}
    inline operator fun unaryMinus() = {{ T }}Aabb3(-min, -max)

    @JvmName("add")
    inline operator fun plus (s: {{ Type }}) = {{ T }}Aabb3(min + s, max + s)
    @JvmName("sub")
    inline operator fun minus(s: {{ Type }}) = {{ T }}Aabb3(min - s, max - s)
    @JvmName("mul")
    inline operator fun times(s: {{ Type }}) = {{ T }}Aabb3(min * s, max * s)
    @JvmName("div")
    inline operator fun div  (s: {{ Type }}) = {{ T }}Aabb3(min / s, max / s)

    @JvmName("add")
    inline operator fun plus (b: {{ T }}Aabb3) = {{ T }}Aabb3(min + b.min, max + b.max)
    @JvmName("sub")
    inline operator fun minus(b: {{ T }}Aabb3) = {{ T }}Aabb3(min - b.min, max - b.max)
    @JvmName("mul")
    inline operator fun times(b: {{ T }}Aabb3) = {{ T }}Aabb3(min * b.min, max * b.max)
    @JvmName("div")
    inline operator fun div  (b: {{ T }}Aabb3) = {{ T }}Aabb3(min / b.min, max / b.max)
}

@JvmName("add")
inline operator fun {{ Type }}.plus (b: {{ T }}Aabb3) = {{ T }}Aabb3(this + b.min, this + b.max)
@JvmName("sub")
inline operator fun {{ Type }}.minus(b: {{ T }}Aabb3) = {{ T }}Aabb3(this - b.min, this - b.max)
@JvmName("mul")
inline operator fun {{ Type }}.times(b: {{ T }}Aabb3) = {{ T }}Aabb3(this * b.min, this * b.max)
@JvmName("div")
inline operator fun {{ Type }}.div  (b: {{ T }}Aabb3) = {{ T }}Aabb3(this / b.min, this / b.max)

inline fun intersects(b: {{ T }}Aabb3, v: {{ T }}Vec3) = all(v ge b.min) && all(v le b.max)

inline fun expand(b: {{ T }}Aabb3, v: {{ T }}Vec3) = {{ T }}Aabb3(b.min - v, b.max + v)

inline fun extend(b: {{ T }}Aabb3, v: {{ T }}Vec3) = {{ T }}Aabb3(min(b.min, v), max(b.max, v))

inline fun extend(a: {{ T }}Aabb3, b: {{ T }}Aabb3) = {{ T }}Aabb3(min(a.min, b.min), max(a.max, b.max))

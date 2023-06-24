@file:Suppress("NOTHING_TO_INLINE")

package io.github.aecsocket.klam

data class {{ T }}Aabb4(
    @JvmField val min: {{ T }}Vec4,
    @JvmField val max: {{ T }}Vec4,
) {
    fun asString(fmt: String) = "[${min.asString(fmt)} .. ${max.asString(fmt)}]"
    override fun toString() = asString("{{ toStringFormat }}")

    inline fun mapVector(block: ({{ T }}Vec4) -> {{ T }}Vec4) = {{ T }}Aabb4(block(min), block(max))
    inline fun mapScalar(block: ({{ Type }}) -> {{ Type }}) = {{ T }}Aabb4(min.map(block), max.map(block))

{% for cast in decimalCasts %}
    inline fun mapVector{{ cast.Type }}(block: ({{ T }}Vec4) -> {{ cast.T }}Vec4) = {{ cast.T }}Aabb4(block(min), block(max))
    inline fun mapScalar{{ cast.Type }}(block: ({{ Type }}) -> {{ cast.Type }}) = {{ cast.T }}Aabb4(min.map{{ cast.Type }}(block), max.map{{ cast.Type }}(block))
    fun {{ cast.fn }} = {{ cast.T }}Aabb4(min.{{ cast.fn }}, max.{{ cast.fn }})

{% endfor %}
    inline operator fun unaryMinus() = {{ T }}Aabb4(-min, -max)

    @JvmName("add")
    inline operator fun plus (s: {{ Type }}) = {{ T }}Aabb4(min + s, max + s)
    @JvmName("sub")
    inline operator fun minus(s: {{ Type }}) = {{ T }}Aabb4(min - s, max - s)
    @JvmName("mul")
    inline operator fun times(s: {{ Type }}) = {{ T }}Aabb4(min * s, max * s)
    @JvmName("div")
    inline operator fun div  (s: {{ Type }}) = {{ T }}Aabb4(min / s, max / s)

    @JvmName("add")
    inline operator fun plus (b: {{ T }}Aabb4) = {{ T }}Aabb4(min + b.min, max + b.max)
    @JvmName("sub")
    inline operator fun minus(b: {{ T }}Aabb4) = {{ T }}Aabb4(min - b.min, max - b.max)
    @JvmName("mul")
    inline operator fun times(b: {{ T }}Aabb4) = {{ T }}Aabb4(min * b.min, max * b.max)
    @JvmName("div")
    inline operator fun div  (b: {{ T }}Aabb4) = {{ T }}Aabb4(min / b.min, max / b.max)
}

@JvmName("add")
inline operator fun {{ Type }}.plus (b: {{ T }}Aabb4) = {{ T }}Aabb4(this + b.min, this + b.max)
@JvmName("sub")
inline operator fun {{ Type }}.minus(b: {{ T }}Aabb4) = {{ T }}Aabb4(this - b.min, this - b.max)
@JvmName("mul")
inline operator fun {{ Type }}.times(b: {{ T }}Aabb4) = {{ T }}Aabb4(this * b.min, this * b.max)
@JvmName("div")
inline operator fun {{ Type }}.div  (b: {{ T }}Aabb4) = {{ T }}Aabb4(this / b.min, this / b.max)

inline fun intersects(b: {{ T }}Aabb4, v: {{ T }}Vec4) = all(v ge b.min) && all(v le b.max)

inline fun expand(b: {{ T }}Aabb4, v: {{ T }}Vec4) = {{ T }}Aabb4(b.min - v, b.max + v)

inline fun extend(b: {{ T }}Aabb4, v: {{ T }}Vec4) = {{ T }}Aabb4(min(b.min, v), max(b.max, v))

inline fun extend(a: {{ T }}Aabb4, b: {{ T }}Aabb4) = {{ T }}Aabb4(min(a.min, b.min), max(a.max, b.max))

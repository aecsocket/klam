package io.github.aecsocket.klam

import kotlin.math.*

fun asQuat(v: {{ T }}Vec3, order: EulerOrder): {{ T }}Quat {
    val s1 = sin(v.x / {{ two }}); val c1 = cos(v.x / {{ two }})
    val s2 = sin(v.y / {{ two }}); val c2 = cos(v.y / {{ two }})
    val s3 = sin(v.z / {{ two }}); val c3 = cos(v.z / {{ two }})

    return when (order) {
        EulerOrder.XYZ -> {{ T }}Quat(
            s1 * c2 * c3 + c1 * s2 * s3,
            c1 * s2 * c3 - s1 * c2 * s3,
            c1 * c2 * s3 + s1 * s2 * c3,
            c1 * c2 * c3 - s1 * s2 * s3
        )
        EulerOrder.YXZ -> {{ T }}Quat(
            s1 * c2 * c3 + c1 * s2 * s3,
            c1 * s2 * c3 - s1 * c2 * s3,
            c1 * c2 * s3 - s1 * s2 * c3,
            c1 * c2 * c3 + s1 * s2 * s3
        )
        EulerOrder.ZXY -> {{ T }}Quat(
            s1 * c2 * c3 - c1 * s2 * s3,
            c1 * s2 * c3 + s1 * c2 * s3,
            c1 * c2 * s3 + s1 * s2 * c3,
            c1 * c2 * c3 - s1 * s2 * s3
        )
        EulerOrder.ZYX -> {{ T }}Quat(
            s1 * c2 * c3 - c1 * s2 * s3,
            c1 * s2 * c3 + s1 * c2 * s3,
            c1 * c2 * s3 - s1 * s2 * c3,
            c1 * c2 * c3 + s1 * s2 * s3
        )
        EulerOrder.YZX -> {{ T }}Quat(
            s1 * c2 * c3 + c1 * s2 * s3,
            c1 * s2 * c3 + s1 * c2 * s3,
            c1 * c2 * s3 - s1 * s2 * c3,
            c1 * c2 * c3 - s1 * s2 * s3
        )
        EulerOrder.XZY -> {{ T }}Quat(
            s1 * c2 * c3 - c1 * s2 * s3,
            c1 * s2 * c3 - s1 * c2 * s3,
            c1 * c2 * s3 + s1 * s2 * c3,
            c1 * c2 * c3 + s1 * s2 * s3,
        )
    }
}

fun asMatrix(q: {{ T }}Quat): {{ T }}Mat3 {
    val x2 = q.x+q.x; val y2 = q.y+q.y; val z2 = q.z+q.z
    val xx = q.x*x2;  val xy = q.x*y2;  val xz = q.x*z2
    val yy = q.y*y2;  val yz = q.y*z2;  val zz = q.z*z2
    val wx = q.w*x2;  val wy = q.w*y2;  val wz = q.w*z2

    return {{ T }}Mat3(
        {{ one }} - (yy+zz), xy-wz, xz+wy,
        xy+wz, {{ one }} - (xx+zz), yz-wx,
        xz-wy, yz+wx, {{ one }} - (xx+yy),
    )
}

fun asQuat(m: {{ T }}Mat3): {{ T }}Quat {
    val trace = m[0, 0] + m[1, 1] + m[2, 2]
    return when {
        trace >= 0 -> {
            val s = {{ half }} / sqrt(trace + {{ one }})
            {{ T }}Quat(
                (m[2, 1] - m[1, 2]) * s,
                (m[0, 2] - m[2, 0]) * s,
                (m[1, 0] - m[0, 1]) * s,
                {{ quarter }} / s
            )
        }
        m[0, 0] > m[1, 1] && m[0, 0] > m[2, 2] -> {
            val s = {{ two }} * sqrt({{ one }} + m[0, 0] - m[1, 1] - m[2, 2])
            {{ T }}Quat(
                {{ quarter }} * s,
                (m[0, 1] + m[1, 0]) / s,
                (m[0, 2] + m[2, 0]) / s,
                (m[2, 1] - m[1, 2]) / s
            )
        }
        m[1, 1] > m[2, 2] -> {
            val s = {{ two }} * sqrt({{ one }} + m[1, 1] - m[0, 0] - m[2, 2])
            {{ T }}Quat(
                (m[0, 1] + m[1, 0]) / s,
                {{ quarter }} * s,
                (m[1, 2] + m[2, 1]) / s,
                (m[0, 2] - m[2, 0]) / s
            )
        }
        else -> {
            val s = {{ two }} * sqrt({{ one }} + m[2, 2] - m[0, 0] - m[1, 1])
            {{ T }}Quat(
                (m[0, 2] + m[2, 0]) / s,
                (m[1, 2] + m[2, 1]) / s,
                {{ quarter }} * s,
                (m[1, 0] - m[0, 1]) / s
            )
        }
    }
}

fun asEuler(m: {{ T }}Mat3, order: EulerOrder): {{ T }}Vec3 {
    return when (order) {
        EulerOrder.XYZ -> {
            val y = asin(clamp(m[0, 2], -{{ one }}, {{ one }}))
            if (kotlin.math.abs(m[0, 2]) < ONE_EPSILON_{{ T }}) {{ T }}Vec3(
                atan2(-m[1, 2], m[2, 2]),
                y,
                atan2(-m[0, 1], m[0, 0]),
            ) else {{ T }}Vec3(
                atan2(m[2, 1], m[1, 1]),
                y,
                {{ zero }},
            )
        }
        EulerOrder.YXZ -> {
            val x = asin(-clamp(m[1, 2], -{{ one }}, {{ one }}))
            if (kotlin.math.abs(m[1, 2]) < ONE_EPSILON_{{ T }}) {{ T }}Vec3(
                x,
                atan2(m[0, 2], m[2, 2]),
                atan2(m[1, 0], m[1, 1]),
            ) else {{ T }}Vec3(
                x,
                atan2(-m[2, 0], m[0, 0]),
                {{ zero }},
            )
        }
        EulerOrder.ZXY -> {
            val x = asin(clamp(m[2, 1], -{{ one }}, {{ one }}))
            return if (kotlin.math.abs(m[2, 1]) < ONE_EPSILON_{{ T }}) {{ T }}Vec3(
                x,
                atan2(-m[2, 0], m[2, 2]),
                atan2(-m[0, 1], m[1, 1]),
            ) else {{ T }}Vec3(
                x,
                {{ zero }},
                atan2(m[1, 0], m[0, 0]),
            )
        }
        EulerOrder.ZYX -> {
            val y = asin(-clamp(m[2, 0], -{{ one }}, {{ one }}))
            if (kotlin.math.abs(m[2, 0]) < ONE_EPSILON_{{ T }}) {{ T }}Vec3(
                atan2(m[2, 1], m[2, 2]),
                y,
                atan2(m[1, 0], m[0, 0]),
            ) else {{ T }}Vec3(
                {{ zero }},
                y,
                atan2(-m[0, 1], m[1, 1]),
            )
        }
        EulerOrder.YZX -> {
            val z = asin(clamp(m[1, 0], -{{ one }}, {{ one }}))
            if (kotlin.math.abs(m[1, 0]) < ONE_EPSILON_{{ T }}) {{ T }}Vec3(
                atan2(-m[1, 2], m[1, 1]),
                atan2(-m[2, 0], m[0, 0]),
                z,
            ) else {{ T }}Vec3(
                {{ zero }},
                atan2(m[0, 2], m[2, 2]),
                z,
            )
        }
        EulerOrder.XZY -> {
            val z = asin(-clamp(m[0, 1], -{{ one }}, {{ one }}))
            return if (kotlin.math.abs(m[0, 1]) < ONE_EPSILON_{{ T }}) {{ T }}Vec3(
                atan2(m[2, 1], m[1, 1]),
                atan2(m[0, 2], m[0, 0]),
                z,
            ) else {{ T }}Vec3(
                atan2(-m[1, 2], m[2, 2]),
                {{ zero }},
                z,
            )
        }
    }
}

fun asEuler(q: {{ T }}Quat, order: EulerOrder): {{ T }}Vec3 = asEuler(asMatrix(q), order)

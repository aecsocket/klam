package io.github.aecsocket.klam

import kotlin.math.*

enum class EulerOrder {
    XYZ,
    YXZ,
    ZXY,
    ZYX,
    YZX,
    XZY,
}

fun asQuat(v: FVec3, order: EulerOrder): FQuat {
    val s1 = sin(v.x / 2); val c1 = cos(v.x / 2)
    val s2 = sin(v.y / 2); val c2 = cos(v.y / 2)
    val s3 = sin(v.z / 2); val c3 = cos(v.z / 2)

    return when (order) {
        EulerOrder.XYZ -> FQuat(
            s1*c2*c3 + c1*s2*s3,
            c1*s2*c3 - s1*c2*s3,
            c1*c2*s3 + s1*s2*c3,
            c1*c2*c3 - s1*s2*s3
        )
        EulerOrder.YXZ -> FQuat(
            s1*c2*c3 + c1*s2*s3,
            c1*s2*c3 - s1*c2*s3,
            c1*c2*s3 - s1*s2*c3,
            c1*c2*c3 + s1*s2*s3
        )
        EulerOrder.ZXY -> FQuat(
            s1*c2*c3 - c1*s2*s3,
            c1*s2*c3 + s1*c2*s3,
            c1*c2*s3 + s1*s2*c3,
            c1*c2*c3 - s1*s2*s3
        )
        EulerOrder.ZYX -> FQuat(
            s1*c2*c3 - c1*s2*s3,
            c1*s2*c3 + s1*c2*s3,
            c1*c2*s3 - s1*s2*c3,
            c1*c2*c3 + s1*s2*s3
        )
        EulerOrder.YZX -> FQuat(
            s1*c2*c3 + c1*s2*s3,
            c1*s2*c3 + s1*c2*s3,
            c1*c2*s3 - s1*s2*c3,
            c1*c2*c3 - s1*s2*s3
        )
        EulerOrder.XZY -> FQuat(
            s1*c2*c3 - c1*s2*s3,
            c1*s2*c3 - s1*c2*s3,
            c1*c2*s3 + s1*s2*c3,
            c1*c2*c3 + s1*s2*s3,
        )
    }
}
fun asQuat(v: DVec3, order: EulerOrder): DQuat {
    val s1 = sin(v.x / 2); val c1 = cos(v.x / 2)
    val s2 = sin(v.y / 2); val c2 = cos(v.y / 2)
    val s3 = sin(v.z / 2); val c3 = cos(v.z / 2)

    return when (order) {
        EulerOrder.XYZ -> DQuat(
            s1*c2*c3 + c1*s2*s3,
            c1*s2*c3 - s1*c2*s3,
            c1*c2*s3 + s1*s2*c3,
            c1*c2*c3 - s1*s2*s3
        )
        EulerOrder.YXZ -> DQuat(
            s1*c2*c3 + c1*s2*s3,
            c1*s2*c3 - s1*c2*s3,
            c1*c2*s3 - s1*s2*c3,
            c1*c2*c3 + s1*s2*s3
        )
        EulerOrder.ZXY -> DQuat(
            s1*c2*c3 - c1*s2*s3,
            c1*s2*c3 + s1*c2*s3,
            c1*c2*s3 + s1*s2*c3,
            c1*c2*c3 - s1*s2*s3
        )
        EulerOrder.ZYX -> DQuat(
            s1*c2*c3 - c1*s2*s3,
            c1*s2*c3 + s1*c2*s3,
            c1*c2*s3 - s1*s2*c3,
            c1*c2*c3 + s1*s2*s3
        )
        EulerOrder.YZX -> DQuat(
            s1*c2*c3 + c1*s2*s3,
            c1*s2*c3 + s1*c2*s3,
            c1*c2*s3 - s1*s2*c3,
            c1*c2*c3 - s1*s2*s3
        )
        EulerOrder.XZY -> DQuat(
            s1*c2*c3 - c1*s2*s3,
            c1*s2*c3 - s1*c2*s3,
            c1*c2*s3 + s1*s2*c3,
            c1*c2*c3 + s1*s2*s3,
        )
    }
}

fun asMatrix(q: FQuat): FMat3 {
    val x2 = q.x+q.x; val y2 = q.y+q.y; val z2 = q.z+q.z
    val xx = q.x*x2;  val xy = q.x*y2;  val xz = q.x*z2
    val yy = q.y*y2;  val yz = q.y*z2;  val zz = q.z*z2
    val wx = q.w*x2;  val wy = q.w*y2;  val wz = q.w*z2

    return FMat3(
        1 - (yy+zz), xy-wz, xz+wy,
        xy+wz, 1 - (xx+zz), yz-wx,
        xz-wy, yz+wx, 1 - (xx+yy)
    )
}
fun asMatrix(q: DQuat): DMat3 {
    val x2 = q.x+q.x; val y2 = q.y+q.y; val z2 = q.z+q.z
    val xx = q.x*x2;  val xy = q.x*y2;  val xz = q.x*z2
    val yy = q.y*y2;  val yz = q.y*z2;  val zz = q.z*z2
    val wx = q.w*x2;  val wy = q.w*y2;  val wz = q.w*z2

    return DMat3(
        1 - (yy+zz), xy-wz, xz+wy,
        xy+wz, 1 - (xx+zz), yz-wx,
        xz-wy, yz+wx, 1 - (xx+yy)
    )
}

fun asQuat(m: FMat3): FQuat {
    val trace = m[0, 0] + m[1, 1] + m[2, 2]
    return when {
        trace >= 0 -> {
            val s = 0.5f / sqrt(trace + 1)
            FQuat(
                (m[2, 1] - m[1, 2]) * s,
                (m[0, 2] - m[2, 0]) * s,
                (m[1, 0] - m[0, 1]) * s,
                0.25f / s
            )
        }
        m[0, 0] > m[1, 1] && m[0, 0] > m[2, 2] -> {
            val s = 2f * sqrt(1f + m[0, 0] - m[1, 1] - m[2, 2])
            FQuat(
                0.25f * s,
                (m[0, 1] + m[1, 0]) / s,
                (m[0, 2] + m[2, 0]) / s,
                (m[2, 1] - m[1, 2]) / s
            )
        }
        m[1, 1] > m[2, 2] -> {
            val s = 2f * sqrt(1f + m[1, 1] - m[0, 0] - m[2, 2])
            FQuat(
                (m[0, 1] + m[1, 0]) / s,
                0.25f * s,
                (m[1, 2] + m[2, 1]) / s,
                (m[0, 2] - m[2, 0]) / s
            )
        }
        else -> {
            val s = 2f * sqrt(1f + m[2, 2] - m[0, 0] - m[1, 1])
            FQuat(
                (m[0, 2] + m[2, 0]) / s,
                (m[1, 2] + m[2, 1]) / s,
                0.25f * s,
                (m[1, 0] - m[0, 1]) / s
            )
        }
    }
}
fun asQuat(m: DMat3): DQuat {
    val trace = m[0, 0] + m[1, 1] + m[2, 2]
    return when {
        trace >= 0 -> {
            val s = 0.5 / sqrt(trace + 1)
            DQuat(
                (m[2, 1] - m[1, 2]) * s,
                (m[0, 2] - m[2, 0]) * s,
                (m[1, 0] - m[0, 1]) * s,
                0.25 / s
            )
        }
        m[0, 0] > m[1, 1] && m[0, 0] > m[2, 2] -> {
            val s = 2 * sqrt(1 + m[0, 0] - m[1, 1] - m[2, 2])
            DQuat(
                0.25 * s,
                (m[0, 1] + m[1, 0]) / s,
                (m[0, 2] + m[2, 0]) / s,
                (m[2, 1] - m[1, 2]) / s
            )
        }
        m[1, 1] > m[2, 2] -> {
            val s = 2 * sqrt(1 + m[1, 1] - m[0, 0] - m[2, 2])
            DQuat(
                (m[0, 1] + m[1, 0]) / s,
                0.25 * s,
                (m[1, 2] + m[2, 1]) / s,
                (m[0, 2] - m[2, 0]) / s
            )
        }
        else -> {
            val s = 2 * sqrt(1 + m[2, 2] - m[0, 0] - m[1, 1])
            DQuat(
                (m[0, 2] + m[2, 0]) / s,
                (m[1, 2] + m[2, 1]) / s,
                0.25 * s,
                (m[1, 0] - m[0, 1]) / s
            )
        }
    }
}

fun asEuler(m: FMat3, order: EulerOrder): FVec3 {
    return when (order) {
        EulerOrder.XYZ -> {
            val y = asin(clamp(m[0, 2], -1f, 1f))
            if (abs(m[0, 2]) < ONE_EPSILON_D) FVec3(
                atan2(-m[1, 2], m[2, 2]),
                y,
                atan2(-m[0, 1], m[0, 0]),
            ) else FVec3(
                atan2(m[2, 1], m[1, 1]),
                y,
                0f,
            )
        }
        EulerOrder.YXZ -> {
            val x = asin(-clamp(m[1, 2], -1f, 1f))
            if (abs(m[1, 2]) < ONE_EPSILON_D) FVec3(
                x,
                atan2(m[0, 2], m[2, 2]),
                atan2(m[1, 0], m[1, 1]),
            ) else FVec3(
                x,
                atan2(-m[2, 0], m[0, 0]),
                0f,
            )
        }
        EulerOrder.ZXY -> {
            val x = asin(clamp(m[2, 1], -1f, 1f))
            return if (abs(m[2, 1]) < ONE_EPSILON_D) FVec3(
                x,
                atan2(-m[2, 0], m[2, 2]),
                atan2(-m[0, 1], m[1, 1]),
            ) else FVec3(
                x,
                0f,
                atan2(m[1, 0], m[0, 0]),
            )
        }
        EulerOrder.ZYX -> {
            val y = asin(-clamp(m[2, 0], -1f, 1f))
            if (abs(m[2, 0]) < ONE_EPSILON_D) FVec3(
                atan2(m[2, 1], m[2, 2]),
                y,
                atan2(m[1, 0], m[0, 0]),
            ) else FVec3(
                0f,
                y,
                atan2(-m[0, 1], m[1, 1]),
            )
        }
        EulerOrder.YZX -> {
            val z = asin(clamp(m[1, 0], -1f, 1f))
            if (abs(m[1, 0]) < ONE_EPSILON_D) FVec3(
                atan2(-m[1, 2], m[1, 1]),
                atan2(-m[2, 0], m[0, 0]),
                z,
            ) else FVec3(
                0f,
                atan2(m[0, 2], m[2, 2]),
                z,
            )
        }
        EulerOrder.XZY -> {
            val z = asin(-clamp(m[0, 1], -1f, 1f))
            return if (abs(m[0, 1]) < ONE_EPSILON_D) FVec3(
                atan2(m[2, 1], m[1, 1]),
                atan2(m[0, 2], m[0, 0]),
                z,
            ) else FVec3(
                atan2(-m[1, 2], m[2, 2]),
                0f,
                z,
            )
        }
    }
}
fun asEuler(m: DMat3, order: EulerOrder): DVec3 {
    return when (order) {
        EulerOrder.XYZ -> {
            val y = asin(clamp(m[0, 2], -1.0, 1.0))
            if (abs(m[0, 2]) < ONE_EPSILON_D) DVec3(
                atan2(-m[1, 2], m[2, 2]),
                y,
                atan2(-m[0, 1], m[0, 0]),
            ) else DVec3(
                atan2(m[2, 1], m[1, 1]),
                y,
                0.0,
            )
        }
        EulerOrder.YXZ -> {
            val x = asin(-clamp(m[1, 2], -1.0, 1.0))
            if (abs(m[1, 2]) < ONE_EPSILON_D) DVec3(
                x,
                atan2(m[0, 2], m[2, 2]),
                atan2(m[1, 0], m[1, 1]),
            ) else DVec3(
                x,
                atan2(-m[2, 0], m[0, 0]),
                0.0,
            )
        }
        EulerOrder.ZXY -> {
            val x = asin(clamp(m[2, 1], -1.0, 1.0))
            return if (abs(m[2, 1]) < ONE_EPSILON_D) DVec3(
                x,
                atan2(-m[2, 0], m[2, 2]),
                atan2(-m[0, 1], m[1, 1]),
            ) else DVec3(
                x,
                0.0,
                atan2(m[1, 0], m[0, 0]),
            )
        }
        EulerOrder.ZYX -> {
            val y = asin(-clamp(m[2, 0], -1.0, 1.0))
            if (abs(m[2, 0]) < ONE_EPSILON_D) DVec3(
                atan2(m[2, 1], m[2, 2]),
                y,
                atan2(m[1, 0], m[0, 0]),
            ) else DVec3(
                0.0,
                y,
                atan2(-m[0, 1], m[1, 1]),
            )
        }
        EulerOrder.YZX -> {
            val z = asin(clamp(m[1, 0], -1.0, 1.0))
            if (abs(m[1, 0]) < ONE_EPSILON_D) DVec3(
                atan2(-m[1, 2], m[1, 1]),
                atan2(-m[2, 0], m[0, 0]),
                z,
            ) else DVec3(
                0.0,
                atan2(m[0, 2], m[2, 2]),
                z,
            )
        }
        EulerOrder.XZY -> {
            val z = asin(-clamp(m[0, 1], -1.0, 1.0))
            return if (abs(m[0, 1]) < ONE_EPSILON_D) DVec3(
                atan2(m[2, 1], m[1, 1]),
                atan2(m[0, 2], m[0, 0]),
                z,
            ) else DVec3(
                atan2(-m[1, 2], m[2, 2]),
                0.0,
                z,
            )
        }
    }
}

fun asEuler(q: FQuat, order: EulerOrder) = asEuler(asMatrix(q), order)
fun asEuler(q: DQuat, order: EulerOrder) = asEuler(asMatrix(q), order)

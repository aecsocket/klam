package templating

sealed interface TypeVariant {
    val name: String
    val code: String
    val zero: String
    val one: String
    val zeroField: String
    val oneField: String
    val arrayOf: String
    val nextRandom: String
    val toStringFormat: String
    val isNumber: Boolean
    val isDecimal: Boolean

    fun context(): Map<String, Any> = mapOf(
        "Type" to name,
        "T" to code,
        "zero" to zero,
        "one" to one,
        "Zero" to zeroField,
        "One" to oneField,
        "arrayOf" to arrayOf,
        "nextRandom" to nextRandom,
        "toStringFormat" to toStringFormat,
        "isNumber" to isNumber,
        "isDecimal" to isDecimal,
    )

    object Bool : TypeVariant {
        override val name get() = "Boolean"
        override val code get() = "B"
        override val zero get() = "false"
        override val one get() = "true"
        override val zeroField get() = "False"
        override val oneField get() = "True"
        override val arrayOf get() = "booleanArrayOf"
        override val nextRandom get() = "nextBoolean"
        override val toStringFormat get() = "%s"
        override val isNumber get() = false
        override val isDecimal get() = false
    }

    sealed interface Number : TypeVariant {
        override val zeroField get() = "Zero"
        override val oneField get() = "One"
        override val isNumber get() = true

        val sCode: String
        val sToT: String

        override fun context() = super.context() + mapOf(
            "S" to sCode,
            "sToT" to sToT,
        )
    }

    data class Integer(
        override val name: String,
        override val code: String,
        override val zero: String,
        override val one: String,
        override val arrayOf: String,
        override val nextRandom: String,
        override val sCode: String,
        override val sToT: String,
    ) : Number {
        override val toStringFormat get() = "%d"
        override val isDecimal get() = false
    }

    data class Decimal(
        override val name: String,
        override val code: String,
        override val zero: String,
        val quarter: String,
        val half: String,
        override val one: String,
        val two: String,
        override val arrayOf: String,
        override val nextRandom: String,
        val pi: String,
        val oneEighty: String,
        val epsilon: String,
        val oneEpsilon: String,
        override val sCode: String,
        override val sToT: String,
    ) : Number {
        override val toStringFormat get() = "%f"
        override val isDecimal get() = true

        override fun context() = super.context() + mapOf(
            "quarter" to quarter,
            "half" to half,
            "two" to two,
            "pi" to pi,
            "oneEighty" to oneEighty,
            "epsilon" to epsilon,
            "oneEpsilon" to oneEpsilon,
        )
    }
}

object TypeVariants {
    val Boolean = TypeVariant.Bool

    val Int = TypeVariant.Integer(
        name = "Int", code = "I",
        zero = "0", one = "1",
        arrayOf = "intArrayOf", nextRandom = "nextInt",
        sCode = "L", sToT = "toInt()",
    )

    val Long = TypeVariant.Integer(
        name = "Long", code = "L",
        zero = "0L", one = "1L",
        arrayOf = "longArrayOf", nextRandom = "nextLong",
        sCode = "I", sToT = "toLong()",
    )

    val Float = TypeVariant.Decimal(
        name = "Float", code = "F",
        zero = "0.0f", quarter = "0.25f", half = "0.5f", one = "1.0f", two = "2.0f",
        arrayOf = "floatArrayOf", nextRandom = "nextFloat",
        pi = "kotlin.math.PI.toFloat()", oneEighty = "180.0f",
        epsilon = "0.000001f", oneEpsilon = "0.999999f",
        sCode = "D", sToT = "toFloat()",
    )

    val Double = TypeVariant.Decimal(
        name = "Double", code = "D",
        zero = "0.0", quarter = "0.25", half = "0.5", one = "1.0", two = "2.0",
        arrayOf = "doubleArrayOf", nextRandom = "nextDouble",
        pi = "kotlin.math.PI", oneEighty = "180.0",
        epsilon = "0.000001", oneEpsilon = "0.999999",
        sCode = "F", sToT = "toDouble()",
    )
}

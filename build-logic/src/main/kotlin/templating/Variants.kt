package templating

data class TypeCast(
  val name: String,
  val code: String,
  val fn: String,
) {
  fun context(): Map<String, Any> = mapOf(
    "Type" to name,
    "T" to code,
    "fn" to fn,
  )
}

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
  val numberCasts: List<TypeCast>

  fun context(): Map<String, Any> = mapOf(
    "Type" to name,
    "T" to code,
    "zero" to zero,
    "one" to one,
    "zeroField" to zeroField,
    "oneField" to oneField,
    "arrayOf" to arrayOf,
    "nextRandom" to nextRandom,
    "toStringFormat" to toStringFormat,
    "isNumber" to isNumber,
    "isDecimal" to isDecimal,
    "numberCasts" to numberCasts.map { it.context() },
  )

  object Bool : TypeVariant {
    override val name = "Boolean"
    override val code = "B"
    override val zero = "false"
    override val one = "true"
    override val zeroField = "none"
    override val oneField = "all"
    override val arrayOf = "booleanArrayOf"
    override val nextRandom = "nextBoolean"
    override val toStringFormat = "%s"
    override val isNumber = false
    override val isDecimal = false
    override val numberCasts = emptyList<TypeCast>()
  }

  sealed interface Number : TypeVariant {
    override val zeroField get() = "zero"
    override val oneField get() = "one"
    override val isNumber get() = true
  }

  data class Integer(
    override val name: String,
    override val code: String,
    override val zero: String,
    override val one: String,
    override val arrayOf: String,
    override val nextRandom: String,
    override val numberCasts: List<TypeCast>,
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
    override val numberCasts: List<TypeCast>,
    val decimalCasts: List<TypeCast>,
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
      "decimalCasts" to decimalCasts.map { it.context() },
    )
  }
}

object TypeCasts {
  val int = TypeCast("Int", "I", "toInt()")

  val long = TypeCast("Long", "L", "toLong()")

  val float = TypeCast("Float", "F", "toFloat()")

  val double = TypeCast("Double", "D", "toDouble()")
}

object TypeVariants {
  val Boolean = TypeVariant.Bool

  val Int = TypeVariant.Integer(
    name = "Int", code = "I",
    zero = "0", one = "1",
    arrayOf = "intArrayOf", nextRandom = "nextInt",
    numberCasts = listOf(TypeCasts.long, TypeCasts.float, TypeCasts.double),
  )

  val Long = TypeVariant.Integer(
    name = "Long", code = "L",
    zero = "0L", one = "1L",
    arrayOf = "longArrayOf", nextRandom = "nextLong",
    numberCasts = listOf(TypeCasts.int, TypeCasts.float, TypeCasts.double),
  )

  val Float = TypeVariant.Decimal(
    name = "Float", code = "F",
    zero = "0.0f", quarter = "0.25f", half = "0.5f", one = "1.0f", two = "2.0f",
    arrayOf = "floatArrayOf", nextRandom = "nextFloat",
    pi = "kotlin.math.PI.toFloat()", oneEighty = "180.0f",
    epsilon = "0.000001f", oneEpsilon = "0.999999f",
    numberCasts = listOf(TypeCasts.int, TypeCasts.long, TypeCasts.double),
    decimalCasts = listOf(TypeCasts.double),
  )

  val Double = TypeVariant.Decimal(
    name = "Double", code = "D",
    zero = "0.0", quarter = "0.25", half = "0.5", one = "1.0", two = "2.0",
    arrayOf = "doubleArrayOf", nextRandom = "nextDouble",
    pi = "kotlin.math.PI", oneEighty = "180.0",
    epsilon = "0.000001", oneEpsilon = "0.999999",
    numberCasts = listOf(TypeCasts.int, TypeCasts.long, TypeCasts.float),
    decimalCasts = listOf(TypeCasts.float),
  )
}

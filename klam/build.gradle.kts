import templating.TypeVariant

plugins {
  id("template-conventions")
  id("publishing-conventions")
}

templates {
  extraContextProvider.set { variant -> alternateAccessors(variant) + swizzles(variant) }
}

// alternate accessor and swizzles auto-generator
val realFields = listOf("x", "y", "z", "w")
val proxyFields =
    listOf(
        listOf("r", "g", "b", "a"),
        listOf("s", "t", "p", "q"),
    )
val accessorFields = listOf(realFields) + proxyFields

fun alternateAccessors(variant: TypeVariant): Map<String, String> {
  return (2..4)
      .map { size ->
        "vecAlternateAccessors$size" to
            proxyFields.joinToString("\n") { fieldSet ->
              (0 until size).joinToString("\n") { fieldIdx ->
                val realField = realFields[fieldIdx]
                val proxyField = fieldSet[fieldIdx]
                "inline val ${variant.code}Vec${size}.$proxyField get() = $realField"
              } + "\n"
            }
      }
      .associate { it }
}

fun swizzles(variant: TypeVariant): Map<String, String> {
  fun swizzle(origSize: Int, fields: List<String>, vararg indices: Int): String {
    val size = indices.size
    val swizzle = indices.map { fields[it] }
    val swizzleField = swizzle.joinToString("")
    val swizzleArgs = swizzle.joinToString(", ")
    return "inline val ${variant.code}Vec${origSize}.${swizzleField} get() = ${variant.code}Vec${size}(${swizzleArgs})"
  }

  return mapOf(
      "vecSwizzles2" to
          accessorFields.joinToString("\n\n") { fields ->
            (0 until 2)
                .flatMap { i -> (0 until 2).map { j -> swizzle(2, fields, i, j) } }
                .joinToString("\n")
          } + "\n",
      "vecSwizzles3" to
          accessorFields.joinToString("\n\n") { fields ->
            (0 until 3)
                .flatMap { i ->
                  (0 until 3).flatMap { j ->
                    listOf(
                        swizzle(3, fields, i, j),
                    ) + (0 until 3).map { k -> swizzle(3, fields, i, j, k) }
                  }
                }
                .joinToString("\n")
          } + "\n",
      "vecSwizzles4" to
          accessorFields.joinToString("\n\n") { fields ->
            (0 until 4)
                .flatMap { i ->
                  (0 until 4).flatMap { j ->
                    listOf(
                        swizzle(4, fields, i, j),
                    ) +
                        (0 until 4).flatMap { k ->
                          listOf(
                              swizzle(4, fields, i, j, k),
                          ) + (0 until 4).map { l -> swizzle(4, fields, i, j, k, l) }
                        }
                  }
                }
                .joinToString("\n")
          } + "\n",
  )
}

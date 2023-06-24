<div align="center">

# Klam
[![CI](https://img.shields.io/github/actions/workflow/status/aecsocket/klam/build.yml)](https://github.com/aecsocket/klam/actions/workflows/build.yml)
![Release](https://img.shields.io/maven-central/v/io.github.aecsocket/klam?label=release)
![Snapshot](https://img.shields.io/nexus/s/io.github.aecsocket/klam?label=snapshot&server=https%3A%2F%2Fs01.oss.sonatype.org)

Linear algebra library for 2D/3D applications

### [GitHub](https://github.com/aecsocket/klam)

</div>

Inspired by [glam Rust crate](https://crates.io/crates/glam/), [glm C++ library](https://github.com/g-truc/glm),
[kotlin-math library](https://github.com/romainguy/kotlin-math/), `klam` offers a simple and performant linear algebra
API and classes. The classes and methods are mostly modelled after GLSL symbols - notably, many functions are defined as
top-level functions instead of methods.

This library also offers support for the [Configurate](https://github.com/spongepowered/configurate) serialization
library through `klam-configurate`.

## Usage

```kotlin
repositories {
    mavenCentral()
    // maven("https://s01.oss.sonatype.org/content/repositories/snapshots/") // for snapshot builds
}

dependencies {
    implementation("io.github.aecsocket", "klam", "VERSION")
    // implementation("io.github.aecsocket", "klam-configurate", "VERSION")
}
```

### Types

The various types are defined in a specific format:
- Element type
  - `B` boolean
  - `I` integer
  - `L` long
  - `F` float
  - `D` double
- Structure
  - `(T)Vec(2|3|4)` vector
  - `(T)Mat(2|3|4)` NxN matrix
  - `(T)Quat` quaternion
  - `(T)Iso3` isometric transformation (position + rotation)
  - `(T)Affine3` affine transformation (position + rotation + scale)
  - `(T)Ray` half-infinite line (origin + direction)

All classes are immutable.

### Methods

#### Construction

`Vec` types can be constructed by specifying:
* all components
```kotlin
val vec = FVec2(0.5f, 1.5f, 2.5f)
```

* a single scalar, duplicated across all components
```kotlin
val vec = DVec3(0.0)
```

`Mat` types can be constructed by specifying:
* the vectors (in **column-major** order)
```kotlin
val mat = IMat2(
    IVec2(0, 1),
    IVec2(2, 3),
)
// [
//   0 2
//   1 3
// ]
```

* the individual elements (in **row-major** order)
```kotlin
val mat = IMat2(
    0, 1,
    2, 3,
)
// [
//   0 1
//   2 3
// ]
```

#### Accessors

`Vec` types have element accessors in `xyzw`, `rgba` and `stpq` forms:
```kotlin
val vec = IVec4(0, 1, 2, 3)
assertEquals(vec.x == vec.r == vec.s) // 0
assertEquals(vec.y == vec.g == vec.t) // 1
assertEquals(vec.z == vec.b == vec.p) // 2
assertEquals(vec.w == vec.a == vec.q) // 3

vec.r = 5 // x = 5
vec.q = 10 // w = 10
```

`Vec` types can be swizzled in any permutation:
```kotlin
val vec = IVec3(0, 1, 2)
vec.yx // (1, 0)
vec.zzzz // (2, 2, 2, 2)
vec.rbg // (0, 2, 1)
```

`Vec` and `Quat` types have element index operators:
```kotlin
val vec = FVec4(0.5f, 1.0f, 1.5f, 2.0f)
val quat = FQuat(0.5f, 1.0f, 1.5f, 2.0f)
assertEquals(vec[0] == quat[0]) // 0.5
assertEquals(vec[1] == quat[1]) // 1.0

vec[0] = quat[3] // vec.x = 2.0f
```

`Mat` types can be indexed by column (returning a `Vec`) or by column and row (returning a scalar):
```kotlin
val mat = IMat2.Identity // IMat2(1, 0, 0, 1)
mat[0] // IVec2(1, 0)
mat[0, 0] // 1
mat[0, 1] // 0
```

### Operators

All types have algebraic operator functions:
```kotlin
val v1 = IVec2(1, 2) + IVec2(4, 5) // (5, 7)
val v2 = FQuat(0.0f, 0.0f, 0.0f, 1.0f) * FVec3(1.0f, 1.0f, 1.0f) // (1.0, 1.0, 1.0)
```

Transformations, such as `Mat * Mat` or `Quat * Vec`, are done through the `*` (times) operator.

### Functions

All type-specific functions are declared as top-level functions:
```kotlin
val v1 = FVec3(0.5f, 0.5f, 0.5f)
val v2 = FVec3(0.2f, 0.2f, 0.2f)

val theDot = dot(v1, v2)
val theCross = cross(v1, v2)

val q = DQuat(0.0, 0.0, 0.0, 1.0)
val qInv = inverse(q)
```

### Rotations

`Vec`, `Mat` and `Quat` types are all capable of representing rotations as Euler angles, rotation matrices and
quaternions respectively. They can be converted between using the top-level functions:
* `asQuat(...)` : `*Quat`
* `asMatrix(...)` : `*Mat3`
* `asEuler(...)` : `*Vec3`

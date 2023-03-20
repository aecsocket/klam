package io.github.aecsocket.klam

import org.openjdk.jmh.annotations.*

data class Struct3(var x: Float, var y: Float, var z: Float) {
    fun add(v: Struct3) {
        x += v.x
        y += v.y
        z += v.z
    }
}

data class Struct4(var x: Float, var y: Float, var z: Float, var w: Float = 0.0f) {
    fun add(v: Struct4) {
        x += v.x
        y += v.y
        z += v.z
    }
}

@JvmInline
value class Array3(val array: FloatArray) {
    constructor(x: Float, y: Float, z: Float) : this(floatArrayOf(x, y, z))

    fun add(v: Array3) {
        repeat(3) { i ->
            array[i] += v.array[i]
        }
    }
}

@JvmInline
value class Array4(val array: FloatArray) {
    constructor(x: Float, y: Float, z: Float) : this(floatArrayOf(x, y, z, 0.0f))

    fun add(v: Array4) {
        repeat(3) { i ->
            array[i] += v.array[i]
        }
    }
}

@State(Scope.Benchmark)
open class Struct3ExecutionPlan {
    @Param("10000")
    var iterations: Int = 0

    lateinit var vec: Struct3
    lateinit var add: Struct3

    @Setup
    fun setUp() {
        vec = Struct3(0.0f, 0.0f, 0.0f)
        add = Struct3(1.0f, 2.0f, 3.0f)
    }
}

@State(Scope.Benchmark)
open class Struct4ExecutionPlan {
    @Param("10000")
    var iterations: Int = 0

    lateinit var vec: Struct4
    lateinit var add: Struct4

    @Setup
    fun setUp() {
        vec = Struct4(0.0f, 0.0f, 0.0f)
        add = Struct4(1.0f, 2.0f, 3.0f)
    }
}

@State(Scope.Benchmark)
open class Array3ExecutionPlan {
    @Param("10000")
    var iterations: Int = 0

    var vec: Array3 = Array3(0.0f, 0.0f, 0.0f)
    var add: Array3 = Array3(0.0f, 0.0f, 0.0f)

    @Setup
    fun setUp() {
        vec = Array3(0.0f, 0.0f, 0.0f)
        add = Array3(1.0f, 2.0f, 3.0f)
    }
}

@State(Scope.Benchmark)
open class Array4ExecutionPlan {
    @Param("10000")
    var iterations: Int = 0

    var vec: Array4 = Array4(0.0f, 0.0f, 0.0f)
    var add: Array4 = Array4(0.0f, 0.0f, 0.0f)

    @Setup
    fun setUp() {
        vec = Array4(0.0f, 0.0f, 0.0f)
        add = Array4(1.0f, 2.0f, 3.0f)
    }
}

open class Benchmarks {
    @Benchmark
    @Fork(value = 2, warmups = 1)
    @Warmup(iterations = 1)
    fun struct3(plan: Struct3ExecutionPlan) {
        repeat(plan.iterations) {
            plan.vec.add(plan.add)
        }
    }

    @Benchmark
    @Fork(value = 2, warmups = 1)
    @Warmup(iterations = 1)
    fun struct4(plan: Struct4ExecutionPlan) {
        repeat(plan.iterations) {
            plan.vec.add(plan.add)
        }
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1)
    fun array3(plan: Array3ExecutionPlan) {
        repeat(plan.iterations) {
            plan.vec.add(plan.add)
        }
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1)
    fun array4(plan: Array4ExecutionPlan) {
        repeat(plan.iterations) {
            plan.vec.add(plan.add)
        }
    }
}

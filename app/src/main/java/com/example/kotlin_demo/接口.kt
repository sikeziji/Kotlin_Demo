package com.example.kotlin_demo

//region 实现接口
interface MyInterface {
    fun bar()    // 未实现
    fun foo() {  //已实现
        // 可选的方法体
        println("foo")
    }
}

class Child : MyInterface {
    override fun bar() {
        // 方法体
        println("bar")
    }
}

fun testInterface() {
    val c = Child()
    c.foo();
    c.bar();

}
//endregion


//region 接口中的属性
interface MyInterface1 {
    var name: String //name 属性, 抽象的
    fun bar()
    fun foo() {
        // 可选的方法体
        println("foo")
    }
}

class Child1 : MyInterface1 {
    override var name: String = "runoob" //重写属性
    override fun bar() {
        // 方法体
        println("bar")
    }
}

fun testInterface1() {
    val c = Child1()
    c.foo();
    c.bar();
    println(c.name)
}

//endregion


//region 函数重写

interface A2 {
    fun foo() {
        print(" A ")
    }   // 已实现

    fun bar()                  // 未实现，没有方法体，是抽象的
}


interface B2 {
    fun foo() {
        print(" B ")
    }   // 已实现

    fun bar() {
        print("  B2 bar")
    } // 已实现
}

open class C2 : A2 {
    override fun bar() {
        print("C2 bar")
    }   // 重写
}

class D2 : A2, B2 {
    override fun foo() {
        super<A2>.foo()
        super<B2>.foo()
    }

    override fun bar() {
        super<B2>.bar()
    }
}

fun testInterface2() {
    val d = D2()
    d.foo();
    d.bar();
}
//endregion


fun main() {
//    testInterface()
//    testInterface1()
    testInterface2()
}
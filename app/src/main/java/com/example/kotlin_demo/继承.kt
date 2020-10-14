package com.example.kotlin_demo


fun main() {
//    testExtends()
//    testExtends2()
    testExtends3()

}

//region 类重写 功能
open class A {
    open fun f() {
        print("A")
    }

    fun a() {
        print("a")
    }
}

interface B {
    fun f() {
        print("B")
    } //接口的成员变量默认是 open 的

    fun b() {
        print("b")
    }
}

class C() : A(), B {
    override fun f() {
        super<A>.f()//调用 A.f()
        super<B>.f()//调用 B.f()
    }

    override fun b() {
        super.b()
    }
}

fun testExtends3() {
    val c = C()
    c.f();
}
//endregion


//region 子类没有主构造函数
/**用户基类**/
open class Person3(name: String) {
    /**次级构造函数**/
    constructor(name: String, age: Int) : this(name) {
        //初始化
        println("-------基类次级构造函数---------")
    }
}

/**子类继承 Person 类**/
class Student3 : Person3 {

    /**次级构造函数**/
    constructor(name: String, age: Int, no: String, score: Int) : super(name, age) {
        println("-------继承类次级构造函数---------")
        println("学生名： ${name}")
        println("年龄： ${age}")
        println("学生号： ${no}")
        println("成绩： ${score}")
    }
}

fun testExtends2() {
    var s = Student("Runoob", 18, "S12345", 89)
}
//endregion

//region 子类有主构造函数
open class Person1(var name: String, var age: Int) {// 基类

}

class Student(name: String, age: Int, var no: String, var score: Int) : Person1(name, age) {

}

// 测试
fun testExtends() {
    val s = Student("Runoob", 18, "S12346", 89)
    println("学生名： ${s.name}")
    println("年龄： ${s.age}")
    println("学生号： ${s.no}")
    println("成绩： ${s.score}")
}
//endregion

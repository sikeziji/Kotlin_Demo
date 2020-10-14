package com.example.kotlin_demo

class Runoob() {
    fun foo() = println("foo")
}

fun main() {
//    var runOob: Runoob? = null
//
//    println(runOob?.foo())
//
//    runOob = Runoob()
//
//    runOob.foo()

//    main1();
//    main2();
    main3();

}

class Person {

    var lastName: String = "zhang"
        get() = field.toUpperCase()   // 将变量赋值后转换为大写
        set

    var no: Int = 100
        get() = field                // 后端变量
        set(value) {
            if (value < 10) {       // 如果传入的值小于 10 返回该值
                field = value
            } else {
                field = -1         // 如果传入的值大于等于 10 返回 -1
            }
        }

    var heiht: Float = 145.4f
        private set
}

// 测试
fun main1() {
    var person: Person? = null

    person?.lastName = "wang"

    person = Person()


    println("lastName:${person.lastName}")

    person.no = 9
    println("no:${person.no}")

    person.no = 20
    println("no:${person.no}")

}


class Runoobs constructor(name: String) {  // 类名为 Runoob
    // 大括号内是类体构成
    var url: String = "http://www.runoob.com"
    var country: String = "CN"
    var siteName = name

    init {
        println("初始化网站名: ${name}")
    }

    fun printTest() {
        println("我是类的函数")
    }
}

class Person2 {
    constructor(parent: Person) {
    }
}

/**
 *  测试构造器
 */
fun main2() {
    val runoob = Runoobs("菜鸟教程")
    println(runoob.siteName)
    println(runoob.url)
    println(runoob.country)
    runoob.printTest()
}

class Runoob2 constructor(name: String) {  // 类名为 Runoob
    // 大括号内是类体构成
    var url: String = "http://www.runoob.com"
    var country: String = "CN"
    var siteName = name

    init {
        println("初始化网站名: ${name}")
    }

    // 次构造函数
    constructor (name: String, alexa: Int) : this(name) {
        println("Alexa 排名 $alexa")
    }

    fun printTest() {
        println("我是类的函数")
    }
}

fun main3() {
    val runoob = Runoob2("菜鸟教程", 10000)
    val runoob2 = Runoob2("菜鸟教程")

    println(runoob.siteName)
    println(runoob.url)
    println(runoob.country)
    runoob.printTest()

    println(runoob2.siteName)
    println(runoob2.url)
    println(runoob2.country)
    runoob.printTest()
}


/**
 * 抽象类测试
 */
open class Base {
    open fun f() {}
}

abstract class Derived : Base() {
    override abstract fun f()
}


/**
 * 嵌套类
 */
class Outer {                  // 外部类
    private val bar: Int = 1

    class Nested {             // 嵌套类
        fun foo() = 2
    }
}

fun main4() {
    val demo = Outer.Nested().foo() // 调用格式：外部类.嵌套类.嵌套类方法/属性
    println(demo)    // == 2
}


/**
 * 内部类
 */
class Outer1 {
    private val bar: Int = 1
    var v = "成员属性"

    /**嵌套内部类**/
    inner class Inner {
        fun foo() = bar  // 访问外部类成员
        fun innerTest() {
            var o = this@Outer1 //获取外部类的成员变量
            println("内部类可以引用外部类的成员，例如：" + o.v)
        }
    }
}

fun main5() {
    val demo = Outer1().Inner().foo()
    println(demo) //   1
    val demo2 = Outer1().Inner().innerTest()
    println(demo2)   // 内部类可以引用外部类的成员，例如：成员属性
}
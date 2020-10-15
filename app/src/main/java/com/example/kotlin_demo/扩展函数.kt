package com.example.kotlin_demo

fun main(arg:Array<String>) {
//    UserTest()

//    TestSwap()

//    TestCC()
//    TestCCC()

//    TestNull()

//    TestClass()
//    TestDQ()
//    TestDW()
}

class Dw {
    fun bar() { println("D bar") }
}

class Cw {
    fun bar() { println("C bar") }  // 与 D 类 的 bar 同名

    fun Dw.foo() {
        bar()         // 调用 D.bar()，扩展接收者优先
        this@Cw.bar()  // 调用 C.bar()
    }

    fun caller(d: Dw) {
        d.foo()   // 调用扩展函数
    }
}

fun TestDW() {
    val c: Cw = Cw()
    val d: Dw = Dw()
    c.caller(d)

}


/***
 * 在 C 类内，创建了 D 类的扩展。此时，C 被成为分发接受者，而 D 为扩展接受者。从上例中，可以清楚的看到，在扩展函数中，可以调用派发接收者的成员函数。
 *假如在调用某一个函数，而该函数在分发接受者和扩展接受者均存在，则以扩展接收者优先，要引用分发接收者的成员你可以使用限定的 this 语法。
 */
class Dq {
    fun bar() { println("D bar") }
}

class Cq {
    fun baz() { println("C baz") }

    fun Dq.foo() {
        bar()   // 调用 D.bar
        baz()   // 调用 C.baz
    }

    fun caller(d: Dq) {
        d.foo()   // 调用扩展函数
    }
}

fun TestDQ() {
    val c: Cq = Cq()
    val d: Dq = Dq()
    c.caller(d)

}






//region 伴生对象的扩展
class MyClass {
    companion object { }  // 将被称为 "Companion"
}

fun MyClass.Companion.foo() {
    println("伴随对象的扩展函数")
}

val MyClass.Companion.no: Int
    get() = 10

fun TestClass() {
    println("no:${MyClass.no}")
    MyClass.foo()
}
//endregion

//region 扩展空对象
fun Any?.toString(): String {
    if (this == null) return "null"
    // 空检测之后，“this”会自动转换为非空类型，所以下面的 toString()
    // 解析为 Any 类的成员函数
    return toString()
}
fun TestNull(){
    var t = "bull"
    println(t.toString())
}
//endregion



//region 若扩展函数和成员函数一致，则使用该函数时，会优先使用成员函数。
class CCC {
    fun foo() { println("成员函数") }
}

fun CCC.foo() { println("扩展函数") }

fun TestCCC() {
    var c = CCC()
    c.foo()
}
//endregion

//region 扩展函数是静态解析
open class CC

class DD: CC()

fun CC.foo() = "c"   // 扩展函数 foo

fun DD.foo() = "d"   // 扩展函数 foo

fun printFoo(c : DD) {
    println(c.foo())  // 类型是 C 类
}

fun TestCC(){
    printFoo(DD())
}
//endregion




//region 扩展函数 swap,调换不同位置的值
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]     //  this 对应该列表
    this[index1] = this[index2]
    this[index2] = tmp
}

fun TestSwap() {

    val l = mutableListOf(1, 2, 3)
    // 位置 0 和 2 的值做了互换
    l.swap(0, 2) // 'swap()' 函数内的 'this' 将指向 'l' 的值

    println(l.toString())
}
//endregion




//region 实例扩展User
class User(var name:String)

/**扩展函数**/
fun User.Print(){
    print("用户名 $name")
}

fun UserTest(){
    var user = User("Runoob")
    user.Print()
}
//endregion

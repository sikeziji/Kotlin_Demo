package com.example.kotlin_demo

fun main() {
//    //结果 3
//    println(sum(1, 2))
//    //结果 3
//    println(sum1(1, 2))
//    //结果 3
//    println(sum2(1, 2))
//    //结果 kotlin.Unit 也就是无返回值
//    println(printSum(1, 2))
//    //可以省略无参类型
//    println(printSum1(1, 2))
//    //可变长参数
//    println(vars(1, 2))
//
//    mains()
//
//    Test1()
//
////    println("in 关键字" + isNotDigit('1'))
//    isNotDigit('1')

    TestQuJian()

}

/**
 *  函数定义使用关键字 fun，参数格式为：参数 : 类型
 *
 * 两数之和
 */
fun sum(a: Int, b: Int): Int { // Int 参数，返回值 Int
    return a + b;
}

/**
 * 表达式作为函数体，返回类型自动推断：
 */
fun sum1(a: Int, b: Int) = a + b

/**
 * 同上，只是kotlin中定义 public 方法则必须明确写出返回类型
 */
public fun sum2(a: Int, b: Int): Int = a + b   // public 方法则必须明确写出返回类型


fun printSum(a: Int, b: Int): Unit {
    println(a + b)
}

// 如果是返回 Unit类型，则可以省略(对于public方法也是这样)：
fun printSum1(a: Int, b: Int) {
    print(a + b)
}


/**
 * 可变长参数函数，用 vararg 关键字进行标识
 */
fun vars(vararg v: Int) {
    for (vt in v) {
        println("vt:" + vt)
    }
}


/**
 *lambda表达式使用实例：
 */
fun mains() {
    val sumLambda: (Int, Int) -> Int = { x, y -> x + y }
    println(sumLambda(1, 2))  // 输出 3
}


/**
 * 测试常亮与变量
 */
fun Test() {
    val a: Int = 1 // 不可变量

    val b = 1       // 系统自动推断变量类型为Int

    val c: Int      // 如果不在声明时初始化则必须提供变量类型

    c = 1           // 明确赋值,明确赋值后就是不可变量。

    var x = 5        // 系统自动推断变量类型为Int
    x += 1
}


/**
 * 测试字符串模板
 */
fun Test1() {

    var a = 1
// 模板中的简单名称：
    val s1 = "a is $a"

    a = 2
// 模板中的任意表达式：
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s1)
    println(s2)
}


fun Test2() {
    //类型后面加?表示可为空
    var age: String? = "23"
//抛出空指针异常
    val ages = age!!.toInt()
//不做处理返回 null
    val ages1 = age?.toInt()
//age为空返回-1
    val ages2 = age?.toInt() ?: -1
}

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // 做过类型判断以后，obj会被系统自动转换为String类型
        return obj.length
    }

    //在这里还有一种方法，与Java中instanceof不同，使用!is
    // if (obj !is String){
    //   // XXX
    // }

    // 这里的obj仍然是Any类型的引用
    return null
}

fun getStringLength1(obj: Any): Int? {
    if (obj !is String)
        return null
    // 在这个分支中, `obj` 的类型会被自动转换为 `String`
    return obj.length
}


fun getStringLength2(obj: Any): Int? {
    // 在 `&&` 运算符的右侧, `obj` 的类型会被自动转换为 `String`
    if (obj is String && obj.length > 0)
        return obj.length
    return null
}


fun TestQuJian() {

    /**
     *  1.表示区间在1-4之间的所有值
     */
    for (i in 1..4) println("i = " + i)


    /**
     * 2.
     */
    for (i2 in 4..1) println("i2 = " + i2)


    /**
     * 3.
     */
    for (i3 in 1..10) { // 等同于 1 <= i && i <= 10
        println("i3 = " + i3)
    }

    // 4. 使用 step 指定步长，step的相当于 i++
    for (i4 in 1..4 step 2) println("i4 = " + i4) // 输出“13”

    /**
     * 5. downTo相当于i–
     */
    for (i5 in 4 downTo 1 step 2) println("i5 = " + i5) // 输出“42”


    // 6.使用 until 函数排除结束元素
    for (i6 in 1 until 10) {   // i in [1, 10) 排除了 10
        println("i6 = " + i6)
    }

    /**
     * i7
     */
    for (i7 in 4 downTo 2 step 3) println("i7 = " + i7)

}

fun isNotDigit(c: Char) {
    for (c in 'z'..'0') println("c =" + c)
}
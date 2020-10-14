package com.example.kotlin_demo


fun main() {
//    compare()

//    //类型转换
//    casting()

    //数组
//    array()

    //数组类型
//    Arraytest()


//    println(sayHello("wang"))
//    println("你有18岁吗？" + checkAge(19))
//    saveLog(2)

//    println(diaryGenerater("清华大学"))

    gradeStudent(8)
    gradeStudent(5)
    gradeStudent(6)
    gradeStudent(2)
    gradeStudent(10)
}



fun gradeStudent(score:Int){
    when (score) {
        10 -> {
            println("考了满分")
        }
        9 -> {
            println("满意")
        }
        8 -> {
            println("优秀")
        }
        7 -> {
            println("一般")
        }
        6 -> {
            println("及格")
        }
        else -> {
            println("不及格")
        }
    }
}


fun diaryGenerater(placeName:String):String{
    var temple = """
        今天天气晴朗，万里无云，我们去${placeName}游玩，
        首先映入眼帘的是:${placeName},${placeName.length}个鎏金大字。        
    """
    return  temple
}


fun casting() {
    val b: Byte = 1 // OK, 字面值是静态检测的
    val i: Int = b.toInt() // OK
//    类型转换中的方法
//    toByte(): Byte
//    toShort(): Short
//    toInt(): Int
//    toLong(): Long
//    toFloat(): Float
//    toDouble(): Double
//    toChar(): Char


    //自行转换的方式
    val l = 1L + 3 // Long + Int => Long
}


/**
 * 比较测试
 */
fun compare() {
    val a: Int = 10000
    println("a === a " + (a === a)) // true，值相等，对象地址相等

    //经过了装箱，创建了两个不同的对象
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    //虽然经过了装箱，但是值是相等的，都是10000
    println("boxedA === anotherBoxedA:" + (boxedA === anotherBoxedA)) //  false，值相等，对象地址不一样
    println("boxedA == anotherBoxedA :" + (boxedA == anotherBoxedA))// true，值相等
}

//位操作符
fun manipulation() {
//    shl(bits) – 左移位 (Java’s <<)
//    shr(bits) – 右移位 (Java’s >>)
//    ushr(bits) – 无符号右移位 (Java’s >>>)
//    and(bits) – 与
//    or(bits) – 或
//    xor(bits) – 异或
//    inv() – 反向
}


/**
 * char类型
 */
fun charType() {
    fun decimalDigitValue(c: Char): Int {
        if (c !in '0'..'9')
            throw IllegalArgumentException("Out of range")
        return c.toInt() - '0'.toInt() // 显式转换为数字
    }
}


/**
 * 数组操作
 */
fun array() {

    //[1,2,3]
    val a = arrayOf(1, 2, 3)
    //[0,2,4]
    val b = Array(3, { i -> (i * 2) })

    //读取数组内容
    println(a[0])    // 输出结果：1
    println(b[1])    // 输出结果：2
}


fun Arraytest() {
    val x: IntArray = intArrayOf(1, 2, 3)
    x[0] = x[1] + x[2]
    for (x in x) {
        println("x = " + x)
    }
}


/**
 * sayHello
 */
fun sayHello(name: String): String {
    return "hello" + name
}


/**
 * 18岁后才可以喝酒
 */
fun checkAge(age: Int): Boolean {
    return age >= 18
}

/**
 * 保存log
 */
fun saveLog(logLevel: Int) {
    println("level" + logLevel)
}

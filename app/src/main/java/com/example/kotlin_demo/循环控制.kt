package com.example.kotlin_demo


fun main() {
//test1()//访问数组中的元素
//    Test3();//二维数组
//    Test4();//自定义类型的二维数组
//    Test5();//三维数组
//    forTest()//循环测试
    returnTest()//返回测试
}


fun forTest() {
    println("----while 使用-----")
    var x = 5
    //先判断是否为true ，若为true，然后执行一次y--
    while (x > 0) {
        println(x--)
    }
    println("----do...while 使用-----")
    //先执行一次y-- 然后判断是否为true ，若为true则继续进行
    var y = 5
    do {
        println(y--)
    } while (y < 5 && y > 0)
}


fun returnTest() {
    for (i in 1..10) {
        if (i == 3) continue  // i 为 3 时跳过当前循环，继续下一次循环
        println(i)
        if (i > 5) break   // i 为 6 时 跳出循环
    }
}

/**
 * 访问数组中的元素
 */
fun test1() {
    val intArr = intArrayOf(1, 2, 3)
    for (item in intArr) {
        println(item)//遍历intArr里面的元素，item就是元素本身
    }
    for (index in intArr.indices) {
        println(intArr[index])//遍历initArr索引的元素，从0开始
        println(intArr.get(index))//可以通过get(索引)来获取元素
    }

}


/**
 * 数组创建
 */
fun createArray() {
    val array = arrayOf("1", "2")

    for ((index, value) in array.withIndex()) {
        println("the element at $index is $value")
    }

    for (i in array.indices) {
        print(array[i])
    }

    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }

    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }

    val arr = Array(3, { it -> it.inc() })//参数1：数组大小，参数2：一个函数参数的工厂函数
    for (i in arr) {
        println(i)
    }
}

/**
 * 二维数组
 */
fun Test3() {
    //基本类型的二维数组
    val arr = Array(3) { IntArray(3) }//三个长度为3的Int数组的二维数组
    print("arr[1][1]" + arr[1][1])
    for (one in arr) {
        println()
        for (two in one) {
            print(two)
        }
    }
}

//自定义类型的二维数组
fun Test4() {
    //三个长度为3的Demo类型的二维数组，自定义类型的话需要在大括号里面操作
    val arrClass = Array(3) { Array<Demo>(3, { i: Int -> Demo(i) }) }
    for (demos in arrClass) {
        println()
        for (demo in demos) {
            print("${demo.mNum}  ")
        }
    }
}


fun Test5() {
    //正解
    val arrB = Array(3) { Array(3) { Array<Demo>(3) { i: Int -> Demo(i) } } }
    for (one in arrB) {
        println()
        for (two in one) {
            println()
            for (three in two) {
                print(three.mNum)
            }
        }
    }
}


class Demo(num: Int) {
    var mNum: Int? = null

    init {
        this.mNum = num
    }
}


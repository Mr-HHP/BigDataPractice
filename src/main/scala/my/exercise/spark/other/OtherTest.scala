package my.exercise.spark.other

/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/07/29
  **/
object OtherTest {
  def main(args: Array[String]): Unit = {
    val a = new A
    val b = new B
//    println(a.isInstanceOf[A])
//    println(b.isInstanceOf[A])
    val seq = Seq(b, b)
    val (left, right) = seq.partition(_.isInstanceOf[A])
    println(left)
    println(right)
    println(left.nonEmpty)
    println(right.nonEmpty)
  }
}

class T

class A extends T

class B extends T
package my.exercise.spark.bitmap

import org.roaringbitmap.RoaringBitmap

/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/08/15
  **/
object BitMapDemo {
  def main(args: Array[String]): Unit = {
    val roaringBitmap: RoaringBitmap = new RoaringBitmap()
    println("========= 1 ================")
    roaringBitmap.add(2)
    println(roaringBitmap.getCardinality)
    println(roaringBitmap.select(0))
//    println(roaringBitmap.select(1))
//    println(roaringBitmap.select(8))
    println("==== 4 ====")
    roaringBitmap.add(4)
    println(roaringBitmap.getCardinality)
    println("============= 69 =================")
    roaringBitmap.add(6999)
    println(roaringBitmap.getCardinality)
    println(roaringBitmap.select(1))
    println(roaringBitmap.select(2))
    println(roaringBitmap.select(3))
  }
}

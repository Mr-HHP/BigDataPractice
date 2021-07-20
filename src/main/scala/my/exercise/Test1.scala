package my.exercise

/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/01/19
  **/
object Test {
  def main(args: Array[String]): Unit = {
    val t1: T = T(1)
    val t2: T = t1
    val t3: T = T(1)
    val t4: T = T(2)
    t1.copy()
//    println(t1.equals(t2))
//    println(t1.equals(t3))
//    println(t1.equals(t4))
    
    var m1: Map[String, Int] = Map("a" -> 1, "b" -> 2)
    var m2: Map[String, Int] = Map("a" -> 3, "c" -> 2)
    m1 ++= m2
//    println(m1)
//    println(m1.filter(kv => kv._1.equals("a")))

//    println("123".compareTo("1"))
//    println("123".compareTo("123"))
//    println("123".compareTo("1234"))
    
    
    
    
    
    val i: Option[Double] = Some(4.1)
    val j: Option[Double] = None
    val a = i.getOrElse(1)
    val b = i.getOrElse(5)
    val c = j.getOrElse("t")
    println(a)
    println(b)
    println(c)
    
    println(19/2)
    
  }
}

case class T(i: Int)

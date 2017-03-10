package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))

  val s = Set(1)
  val t = Set(2)

  val us = union(s,t)

  println(us.toString)
  println(contains(s,1))
  println(contains(t,2))

  println(contains(us,3))

  for(i<- 1 to 2)
    println(i+ " "+contains(us,i))
}

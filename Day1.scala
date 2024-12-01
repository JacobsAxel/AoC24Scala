import scala.io.Source

@main def day1(): Unit =

  println(result)

//Part1

val lines = Source.fromFile("src/input/1").getLines()
val (left,right) = lines.map( x => 
  val pair = x.split("   ").map(_.toInt)
  (pair(0),pair(1))
  ).toList.unzip

val sortedL = left.sorted
val sortedR = right.sorted
  
val distances = sortedL.zip(sortedR).map((x,y) => math.abs(x-y))

val result = distances.sum

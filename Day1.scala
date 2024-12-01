import scala.io.Source

@main def day1(): Unit =

  println(result1)
  println(result2)

//Part1

val lines = Source.fromFile("src/input/1").getLines()
val (left,right) = lines.map( x => 
  val pair = x.split("   ").map(_.toInt)
  (pair(0),pair(1))
  ).toList.unzip

val (sortedL,sortedR) = (left.sorted,right.sorted)
  
val distances = sortedL.zip(sortedR).map((x,y) => math.abs(x-y))

val result1 = distances.sum

//Part2

val hashMap = right.groupBy(identity).mapValues(_.size)

val countProduct = left.map(x => hashMap.contains(x) match
    case true => x * hashMap(x)
    case false => 0
   ) 

val result2 = countProduct.sum

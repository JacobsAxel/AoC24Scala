import scala.io.Source

@main def day1(): Unit =
  val (left,right) = parse("1")
  println(part1(left,right))
  println(part2(left,right))

//Part1

def parse(file: String): (List[Int],List[Int]) =
  val lines = Source.fromFile("src/input/" ++ file).getLines()
  val (left,right) = lines.map( x => 
    val pair = x.split("   ").map(_.toInt)
    (pair(0),pair(1))
  ).toList.unzip
  (left,right)

def part1(left:List[Int],right:List[Int]): Int = 
  val (sortedL,sortedR) = (left.sorted,right.sorted)
  val distances = sortedL.zip(sortedR).map((x,y) => math.abs(x-y))
  val result1 = distances.sum
  result1

//Part2

def part2(left:List[Int],right:List[Int])=
  val hashMap = right.groupBy(identity).mapValues(_.size)
  val countProduct = left.map(x => hashMap.contains(x) match
      case true => x * hashMap(x)
      case false => 0
    ) 
  val result2 = countProduct.sum
  result2
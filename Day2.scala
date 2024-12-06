import scala.io.Source

@main def day2(): Unit =
  println(part1(parse2("2")))

//Part1

def parse2(file: String): List[List[Array[Int]]] =
    val lines = Source.fromFile("src/input/" ++ file).getLines()
    val reports = lines.map(x => x.split(" ").map(_.toInt).sliding(2).toList).toList
    reports

def part1(windowReports: List[List[Array[Int]]]): Int =
    windowReports.map(x => rowCheck(x)).sum

def pairCheck(pair: Array[Int],direction: Int): Int =
    pair match
        case Array(x,y) if x == y => 0
        case Array(x,y) if x < y && direction == -1 => 0
        case Array(x,y) if x > y && direction == 1 => 0
        case Array(x,y) if Math.abs(x-y) > 3 => 0
        case _ => 1

def rowCheck(row: List[Array[Int]]): Int =
    val pair = row.head
    val direction = if pair(0) > pair(1) then -1 else 1

    if row.exists(x => pairCheck(x, direction) == 0) then 0 else 1

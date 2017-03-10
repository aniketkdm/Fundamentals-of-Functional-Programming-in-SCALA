package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int =
    if (c == 0 || r == c) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    var temp = new Array[Char](chars.size)

    var top = -1

    def check(charsList: List[Char]): Boolean = {
      if (charsList.isEmpty)
        return true

      if (charsList.head != '(' && charsList.head != ')')
        return check(charsList.tail)

      if (charsList.head == '(') {
        top = top + 1
        temp(top) = '('
        return check(charsList.tail)
      }

      // ')'
      if (top > -1) {
        var t = temp(top)
        top -= 1
        return check(charsList.tail)
      }

      false


    }

    var flag = check(chars)

    top < 0 && flag


  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0)
      return 1

    if (money > 0 && coins.isEmpty)
      return 0

    var a = new Array[Int](money + 1)

    a(0) = 1

    def recur(coin: Int) {

      for (i <- coin to money)
        a(i) += a(i - coin)
    }

    for (coin <- coins)
      recur(coin)

    a(money)
  }
}

def abs(x:Double) = if (x < 0) -x else x

def sqrtIter(guess: Double, x: Double): Double =
  if (isGoodEnough(guess, x)) guess
  else sqrtIter(improve(guess, x), x)

def isGoodEnough(guess: Double, x: Double) =
  abs((guess * guess) - x) / x < 0.001

def improve(guess: Double, x: Double) =
  (guess + x / guess) / 2

def sqrt(x: Double) = sqrtIter(1.0, x)

sqrt(0.001)
sqrt(0.1e-20)
sqrt(1.0e20)
sqrt(1.0e50)


/*def union(s: Set, t: Set): Set = {
      var outSet = Set
      for(i <- s)
        outSet(i)

      for(i<-t)
        if(!contains(outSet(i),i))
          outSet(i)

      outSet
    }*/
	
	def iter(a: Int): Boolean = {
      if (a >= -1000 && a<= 1000) {
        if (contains(s, a)) {
          if (p(a)) {
            true
          }
          else
            false
        }
        else
          true
      }
      else
        true
      }
	  
	  
	  def iter(a: Int): Boolean = {
        if (a > 1000) false
        else if (s(a) && !p(a)) false
        else iter(a+1)
      }
      iter(-1000)

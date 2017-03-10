def fact(x: Int) : Int = if(x == 0) 1 else x * fact(x-1)

def fact2(x: Int, mult: Int) : Int =
  if(x == 0) mult else fact2(x-1, x * mult)

fact(4)
fact2(4,1)

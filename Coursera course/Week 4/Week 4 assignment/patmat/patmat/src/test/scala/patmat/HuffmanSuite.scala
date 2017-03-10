package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
	trait TestTrees {
		val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
		val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
	}


  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }


  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }


  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("test times"){
    assert({
      val l = times(List('a','b','a'))
      l === List(('a', 2), ('b', 1)) || l === List(('b', 1), ('a', 2))
    })
  }


  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }


  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("test until"){
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(until(singleton,combine)(leaflist) ===
      List(Fork(Fork(Leaf('e', 1), Leaf('t', 2),List('e','t'),3),Leaf('x',4),List('e','t','x'),7)))
  }

  test("test createCodeTree"){
    new TestTrees {
      var charArr = List('a','b','a')
      assert(createCodeTree(charArr) === Fork(Leaf('b',1),Leaf('a',2),List('b','a'),3))
    }
  }

  test("test decode"){
    new TestTrees {
      assert(decode(t2,List(0,0,1)) === List('a','d'))
    }
  }

  test("frech code"){
    decodedSecret
  }

  test("test encode only"){
    new TestTrees {
      assert(encode(t1)("ab".toList) === List(0,1))
    }
  }

  test("convert and test"){
    new TestTrees {
      val converted = convert(t2)
      assert(codeBits(converted)('a') === List(0,0))
      assert(codeBits(converted)('b') === List(0,1))
      assert(codeBits(converted)('d') === List(1))
    }
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("test quick encode"){
    new TestTrees {
      assert(quickEncode(t2)("adba".toList) === List(0,0,1,0,1,0,0))
    }
  }

}

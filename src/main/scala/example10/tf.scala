package example10

object tf {

  //Initial
  sealed trait Expr
  case class Add(exp1: Expr, exp2: Expr) extends Expr
  case class Eq(exp1: Expr, exp2: Expr) extends Expr
  case class Intg(i: Int) extends Expr
  case class Bool(b: Boolean) extends Expr

  val nonsense = Add(Bool(true), Intg(1)) //not good!

  //Initial Tagged
  sealed trait Expr2
  case class Add2(typ: String = "Int", exp1: Expr, exp2: Expr) extends Expr
  case class Eq2(typ: String = "Boolean", exp1: Expr, exp2: Expr) extends Expr
  case class Intg2(typ: String = "Int", i: Int) extends Expr
  case class Bool2(typ: String ="Boolean", b: Boolean) extends Expr

  //now we check the string and raise an error if

  //Initial Tagless
  //A is a phantom type

  sealed trait Expr3[A]
  case class Add3(expr: Expr3[Int], expr2: Expr3[Int]) extends Expr3[Int]
  case class Eq3(expr: Expr3[Int], expr2: Expr3[Int]) extends Expr3[Boolean]
  case class Int3(i: Int) extends Expr3[Int]
  case class Bool3(b: Boolean) extends Expr3[Boolean]

  //how do you write a function that can evaluate expressions?
  //requires type-level programming
}

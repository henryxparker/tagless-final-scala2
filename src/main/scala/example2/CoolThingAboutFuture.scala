package example2

import scala.concurrent.ExecutionContext
import scala.util.Try

abstract class FakeFuture[T] {
  def onComplete[U](f: Try[T] => U)(implicit executor: ExecutionContext): Unit
}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

var i: Int = 1

def addOne: Future[Unit] = Future(i += 1)

for {
  _ <- addOne
  _ <- addOne
  _ <- addOne
} yield {}

i
import example2.Retry
import example2.SmartHomeFuture
import example2.SmartHomeFutureImpl

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

def atMorning(controller: SmartHomeFuture): Future[String] = {
  val command3 = controller.turnOnSprinklers
  val command2 = Retry.retry(controller.startMorningAlarm, 10)
  val command1 = controller.turnOnFireplace

  for {
    _ <- command1
    _ <- command2
    _ <- command3
    res <- controller.whatHappened
  } yield res
}

var r = ""

atMorning(SmartHomeFutureImpl).onComplete(res =>
  r = res.getOrElse("")
)
Thread.sleep(500)
r
import example2.Retry
import example2.SmartHomeFuture
import example2.SmartHomeFutureImpl

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

def atMorning(controller: SmartHomeFuture): Future[String] =
  for {
    _ <- controller.turnOnFireplace
    _ <- Retry.retry(controller.startMorningAlarm, 10)
    _ <- controller.turnOnSprinklers
    res <- controller.whatHappened
    } yield res


var r = ""

atMorning(SmartHomeFutureImpl).onComplete(res =>
  r = res.get
)
Thread.sleep(500)
r
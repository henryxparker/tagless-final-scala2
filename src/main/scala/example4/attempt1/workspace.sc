import cats.effect.unsafe.implicits.global
import example4.RetryIO
import example4.SmartHomeIO
import example4.SmartHomeIOImpl

def atMorning(controller: SmartHomeIO): String = {
  val result = for {
    _ <- controller.turnOnFireplace
    _ <- RetryIO.retry(controller.startMorningAlarm, 10)
    _ <- controller.turnOnSprinklers
    res <- controller.whatHappened
  } yield res

  result.unsafeRunSync()
}

atMorning(SmartHomeIOImpl)
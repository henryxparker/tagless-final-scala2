import cats.effect.unsafe.implicits.global
import example4.RetryIO
import example4.SmartHomeIO
import example4.SmartHomeIOImpl

def atMorning(controller: SmartHomeIO): String = {
  val command1 = controller.turnOnFireplace
  val command2 = RetryIO.retry(controller.startMorningAlarm, 10)
  val command3 = controller.turnOnSprinklers

  val result = for {
    _ <- command1
    _ <- command2
    _ <- command3
    res <- controller.whatHappened
  } yield res

  result.unsafeRunSync()
}

atMorning(SmartHomeIOImpl)
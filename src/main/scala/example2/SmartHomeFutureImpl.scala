package example2
import java.time.Instant
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object SmartHomeFutureImpl extends SmartHomeFuture {
  var alarmsSounded = 0
  var start: Instant = Instant.now()
  var sprinklersTurnedOn: Instant = Instant.now()

  def turnOnFireplace: Future[Unit] =
    Future {
      start = Instant.now()
    }

  def startMorningAlarm: Future[Boolean] =
    Future {
      if (alarmsSounded >= 3) {
        true
      } else {
        Thread.sleep(100)
        alarmsSounded += 1
        false
      }
    }

  def turnOnSprinklers: Future[Unit] = {
    Future {
      sprinklersTurnedOn = Instant.now()
      Thread.sleep(20)
    }
  }

  def whatHappened: Future[String] = Future.apply(s"Owner spent ${(sprinklersTurnedOn.toEpochMilli - start.toEpochMilli)/10} minutes in the fire! and alarm sounded $alarmsSounded times")
}

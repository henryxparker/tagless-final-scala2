package example4

import cats.effect.IO

import java.time.Instant

object SmartHomeIOImpl extends SmartHomeIO {
  var alarmsSounded = 0
  var start: Instant = Instant.now()
  var sprinklersTurnedOn: Instant = Instant.now()

  def turnOnFireplace: IO[Unit] =
    IO {}

  def startMorningAlarm: IO[Boolean] =
    IO {
      if (alarmsSounded >= 3) {
        true
      } else if (alarmsSounded == 0) {
        start = Instant.now()
        Thread.sleep(100)
        alarmsSounded += 1
        false
      } else {
        Thread.sleep(100)
        alarmsSounded += 1
        false
      }
    }

  def turnOnSprinklers: IO[Unit] = {
    IO {
      sprinklersTurnedOn = Instant.now()
    }
  }

  def whatHappened: IO[String] = IO(s"Owner spent ${(sprinklersTurnedOn.toEpochMilli - start.toEpochMilli)/10} minutes in the fire! and alarm sounded $alarmsSounded times")


}

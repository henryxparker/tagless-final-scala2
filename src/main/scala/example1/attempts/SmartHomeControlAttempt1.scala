package example1.attempts

import example1.PaulsSmartHomeControl
import java.time.Instant

object SmartHomeControlAttempt1 extends PaulsSmartHomeControl {
  var alarmsSounded = 0
  var start: Instant = Instant.now()
  var sprinklersTurnedOn: Instant = Instant.now()

  def turnOnFireplace: Unit = {
    start = Instant.now()
  }

  def wakeupCall: Boolean = {
    if (alarmsSounded >= 3) {
      true
    } else {
      Thread.sleep(100)
      alarmsSounded += 1
      false
    }
  }

  def turnOnSprinklers: Unit = {
    sprinklersTurnedOn = Instant.now()
  }

  def whatHappened: String =
    s"Paul spent ${(SmartHomeControlAttempt1.sprinklersTurnedOn.toEpochMilli - SmartHomeControlAttempt1.start.toEpochMilli)/10} minutes in the fire! and alarm sounded $alarmsSounded times"
}

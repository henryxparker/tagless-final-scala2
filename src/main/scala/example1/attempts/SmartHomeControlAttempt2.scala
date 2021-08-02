package example1.attempts

import example1.PaulsSmartHomeControl

import java.time.Instant

object SmartHomeControlAttempt2 extends PaulsSmartHomeControl {
  var alarmsSounded = 0
  var start: Instant = Instant.now()
  var sprinklersTurnedOn: Instant = Instant.now()

  def turnOnFireplace: Unit = throw new Exception("Whoopsy!")

  def wakeupCall: Boolean = ???

  def turnOnSprinklers: Unit = ???

  def whatHappened: String =
    "The house exploded because an exception occurred"
}


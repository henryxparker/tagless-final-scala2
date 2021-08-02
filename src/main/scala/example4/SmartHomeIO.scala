package example4

import cats.effect.IO

trait SmartHomeIO {
  def turnOnFireplace: IO[Unit]

  def startMorningAlarm: IO[Boolean]

  def turnOnSprinklers: IO[Unit]

  def whatHappened: IO[String]
}

package example9

import scala.language.higherKinds

trait SmartHomeTF[F[_]] {
  def turnOnFireplace: F[Unit]

  def startMorningAlarm: F[Boolean]

  def turnOnSprinklers: F[Unit]

  def whatHappened: F[String]
}


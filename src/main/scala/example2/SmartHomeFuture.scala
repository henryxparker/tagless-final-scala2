package example2

import scala.concurrent.Future

trait SmartHomeFuture {

  def turnOnFireplace: Future[Unit]

  def startMorningAlarm: Future[Boolean]

  def turnOnSprinklers: Future[Unit]

  def whatHappened: Future[String]

}

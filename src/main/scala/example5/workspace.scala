package example5

import cats.effect.IO
import example5.UnimportantImplicits._

object workspace {
  def atMorning(controls: SmartHomeWithErrors): Unit =
    for {
      recipie <- controls.askForBreakfastChoice
      dishes <- recipie.flatTraverse(controls.makeBreakfast)
      _ <-controls.cleanDishes
    } yield {}

}

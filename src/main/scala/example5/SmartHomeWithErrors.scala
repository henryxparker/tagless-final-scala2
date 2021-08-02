package example5

import cats.effect.IO

sealed trait Error

sealed trait BreakfastRecipie

sealed trait DirtyDishes

trait SmartHomeWithErrors {
  def askForBreakfastChoice: IO[Either[Error, BreakfastRecipie]]

  def makeBreakfast(recipie: BreakfastRecipie): IO[Either[Error, List[DirtyDishes]]]

  def cleanDishes(dishes: List[DirtyDishes]): IO[Either[Error, Unit]]

}

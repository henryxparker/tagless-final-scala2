package example6

import cats.data.EitherT
import cats.effect.IO
import example5.BreakfastRecipie
import example5.DirtyDishes
import example5.Error

trait SmartHomeEitherT {
  def askForBreakfastChoice: EitherT[IO, Error, BreakfastRecipie]

  def makeBreakfast(recipie: BreakfastRecipie): EitherT[IO, Error, List[DirtyDishes]]

  def cleanDishes(dishes: List[DirtyDishes]): EitherT[IO, Error, Unit]

}

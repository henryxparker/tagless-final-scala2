package example6

import cats.data.EitherT
import cats.effect.IO
import example5.Error

object workspace {
  def atMorning(controller: SmartHomeEitherT): EitherT[IO, Error, Unit] =
    for {
      foodChoice <- controller.askForBreakfastChoice
      dishes <- controller.makeBreakfast(foodChoice)
      _ <- controller.cleanDishes(dishes)
    } yield {}
}

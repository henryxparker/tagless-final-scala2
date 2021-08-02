package example7

import cats.data.EitherT
import cats.data.StateT
import cats.effect.IO
import cats.~>

object workspace {

  trait State

  type Effect[A] = StateT[EitherT[IO, Error, *], State, A]

  def effect1: Effect[String] = ???

  def effect2: EitherT[IO, Error, String] = ???

  def effect3: IO[String] = ???

  def effect4: StateT[IO, State, String] = ???

  def run: Effect[Unit] =
    for {
      _ <- effect1
      _ <- StateT.liftF[EitherT[IO, Error, *], State, String](effect2)
      _ <- StateT.liftF[EitherT[IO, Error, *], State, String](EitherT.right(effect3))
      _ <- effect4.mapK[EitherT[IO, Error, *]](Lambda[IO ~> EitherT[IO, Error, *]](io => EitherT.right(io)))
    } yield {}


}

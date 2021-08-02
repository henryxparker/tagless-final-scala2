package example5

import cats.Applicative
import cats.FlatMap
import cats.Traverse
import cats.effect.IO

object UnimportantImplicits {
  implicit val ap: Applicative[Either[Error, *]] = ???

  implicit val fm: FlatMap[Either[Error, *]] = ???

  implicit class FT[A](val e: Either[Error, A]) extends AnyVal {
    def flatTraverse[B](fa: A => IO[Either[Error, B]]): IO[Either[Error, B]] =
      Traverse[Either[Error, *]].flatTraverse(e)(fa)
  }
}

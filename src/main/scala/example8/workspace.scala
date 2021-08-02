package example8

import cats.FlatMap
import cats.Monad
import cats.effect.IO
import cats.mtl.Ask
import cats.mtl.Raise
import cats.syntax.all._
import example7.workspace.State

import scala.language.higherKinds

object workspace {

  type EitherTLike[F[_]] = Raise[F, Error]

  type StateTLike[F[_]] = Ask[F, State]

  def run[F[_]](implicit eitherT: EitherTLike[F], stateT: StateTLike[F], fm: FlatMap[F]): F[State] =
    for {
      _ <- eitherT.raise[Error, Unit](???)
      a <- stateT.ask
    } yield a

  trait Sftp[F[_]] {}

  def makeSftp[F[_]]: F[Sftp[F]] = ???

  def program[F[_]: Sftp: Monad]: F[Unit] =
    {}.pure[F]


  def main(): Unit = {
    makeSftp[IO].flatMap(implicit sftp =>
      program
    )
  }

}

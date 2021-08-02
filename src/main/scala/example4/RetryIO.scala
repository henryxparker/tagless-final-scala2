package example4

import cats.effect.IO

object RetryIO {
  def retry(f: IO[Boolean], times: Int): IO[Boolean] = {
    if(times <= 0) IO.pure(false)
    else f.flatMap(res => if(res) IO.pure(true) else retry(f, times-1))
  }

}

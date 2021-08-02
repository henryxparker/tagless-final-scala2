package example2

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Retry {
  def retry(f: =>Future[Boolean], times: Int): Future[Boolean] = {
    if(times <= 0) Future.successful(false)
    else f.flatMap(res => if(res) Future.successful(true) else retry(f, times-1))
  }
}

// src/main/scala/Client.scala
import akka.actor.Actor._
import java.util.Date

object Client extends App {
  val start = System.currentTimeMillis()
  for (i <- 0 to 10000) {
    val actor = remote.actorFor(
      "hello-service", "localhost", 9999)
    val result = actor !! "[%s] Hello".format(i)
    println(result)
  }
  val end = System.currentTimeMillis()
  println("%s sec".format((end - start) / 1000.0))
}

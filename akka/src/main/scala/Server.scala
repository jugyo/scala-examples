// src/main/scala/Server.scala
import akka.actor.Actor
import akka.actor.Actor._

class HelloWorldActor extends Actor {
  def receive = {
    case msg => self reply (msg + " World")
  }
}

object Server extends App {
  remote.start("localhost", 9999).register(
    "hello-service", actorOf[HelloWorldActor])
}

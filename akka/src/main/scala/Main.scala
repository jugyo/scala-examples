import akka.actor.Actor

class MyActor extends Actor {
  def receive = {
    case "test" => println("received test")
    case _ =>      println("received unknown message")
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val myActor = Actor.actorOf[MyActor]
    myActor.start()
    myActor ! "test"
  }
}

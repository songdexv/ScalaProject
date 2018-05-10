package actor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

/**
  * Created by songdexv on 2017/12/26.
  */
case object PingMessage

case object PongMessage

case object StartMessage

case object StopMessage

class Ping(pong: ActorRef) extends Actor {
  var count = 0

  def incrementAndPrint = {
    count += 1;
    println("ping " + count)
  }

  override def receive: Receive = {
    case StartMessage =>
      incrementAndPrint
      pong ! PingMessage
    case PongMessage =>
      if (count > 9) {
        sender ! StopMessage
        println("ping stopped")
        context.stop(self)
      } else {
        incrementAndPrint
        sender ! PingMessage
      }
  }
}

class Pong extends Actor {
  override def receive: Receive = {
    case PingMessage =>
      println(" pong")
      sender ! PongMessage
    case StopMessage =>
      println("pong stopped")
      context.stop(self)
      context.system.terminate()
  }
}

object PingPongTest extends App {
  val system = ActorSystem("PingPongSystem")
  val pong = system.actorOf(Props[Pong], name = "pong")
  val ping = system.actorOf(Props(new Ping(pong)), name = "ping")
  ping ! StartMessage
}

package actor

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by songdexv on 2017/12/26.
  */
class HelloActor extends Actor {
  override def receive: Receive = {
    case "hello" => println("您好！")
    case _ => println("您是？")
  }
}

object Main extends App {
  val system = ActorSystem("HelloSystem")
  // 缺省的Actor构造函数
  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")
  helloActor ! "hello"
  helloActor ! "喂"
}

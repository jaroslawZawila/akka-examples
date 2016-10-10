import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestActorRef, TestKit}
import org.scalatest._

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class HelloAkkaSpec(_system: ActorSystem) extends TestKit(_system)
  with ImplicitSender
  with Matchers
  with FunSpecLike
  with BeforeAndAfterAll {

  def this() = this(ActorSystem("HelloAkkaSpec"))

  override def afterAll(): Unit = {
    Await.result(system.terminate(), Duration.Inf)
  }

  describe("The actor") {

    it("is able to set a new greeting"){

      val greeter = TestActorRef(Props[Greeter])

      greeter ! WhoToGreet("test")

      greeter.underlyingActor.asInstanceOf[Greeter].greeting should be ("Hello, test")
    }

    it("be able to get a new greeting"){
      val greeter = TestActorRef(Props[Greeter], "greeter")

      greeter ! WhoToGreet("test1")
      greeter ! Greet

      expectMsgType[Greeting].message.toString should be ("Hello, test1")
    }
  }
}

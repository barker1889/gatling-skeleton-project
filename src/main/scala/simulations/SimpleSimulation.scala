package simulations

import config.HttpConfig
import io.gatling.core.Predef._
import scenarios._

class SimpleSimulation extends Simulation {

  private val searchScenario = new SearchForSomethingScenario()

  before {
    println("starting")
  }

  setUp(
    searchScenario.builder
      .inject(atOnceUsers(1))
      .protocols(HttpConfig.httpProtocol),
  )

  after {
    println("completed")
  }
}
